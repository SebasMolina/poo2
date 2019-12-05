/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorio;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import excepcion.ProveedorNoEncontradoExcepcion;
import java.sql.ResultSet;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import modelo.ProveedorProducto;
/**
 *
 * @author Click
 */
public class RepositorioProveedorProducto {
    private final Connection conexion;

    public RepositorioProveedorProducto(Connection connection) throws SQLException {
        this.conexion = connection;
        var consulta = connection.createStatement();
        consulta.close();
    }

    public List<ProveedorProducto> listar() throws SQLException {
        var proveedorproducto = new ArrayList<ProveedorProducto>();
        var consulta = conexion.createStatement();
        var resultado = consulta.executeQuery("SELECT * FROM"
                + " persona INNER JOIN direccion ON persona.personaid=direccion.personaid "
                + " LEFT JOIN proveedor ON direccion.personaid=proveedorid WHERE tipopersona=2;");
        
        while (resultado.next()) {
            proveedorproducto.add(
                new ProveedorProducto(
                    resultado.getInt("proveedorid"),
                    resultado.getString("razonsocial"),
                    resultado.getString("telefono"),
                    resultado.getString("calle"),
                    resultado.getInt("numero"),
                    resultado.getString("cp"),
                    resultado.getString("piso"),
                    resultado.getString("dpto"),
                    resultado.getObject("horainicio", LocalTime.class),
                    resultado.getObject("horacierre", LocalTime.class)
                )
            );
        }
        resultado.close();
        consulta.close();
        return proveedorproducto;
    }

    public ProveedorProducto obtener(int identificador) throws SQLException, ProveedorNoEncontradoExcepcion {
        var consulta = conexion.prepareStatement("SELECT * FROM"
                + " persona INNER JOIN direccion ON persona.personaid=direccion.personaid "
                + " LEFT JOIN proveedor ON direccion.personaid=proveedorid "
                + " WHERE tipopersona=2 AND proveedorid=?");
        consulta.setInt(1, identificador);
        var resultado = consulta.executeQuery();
        try {
            if (resultado.next()) {
                return new ProveedorProducto(
//aca va el constructor con todos los parametros
                    resultado.getInt("proveedorid"),
                    resultado.getString("nombre"),
                    resultado.getString("apellido"),
                    resultado.getString("mail"),
                    resultado.getString("contrasenia"),
                    resultado.getString("razonsocial"),
                    resultado.getString("telefono"),
                    resultado.getString("ciudad"),
                    resultado.getString("calle"),
                    resultado.getInt("numero"),
                    resultado.getString("cp"),
                    resultado.getString("piso"),
                    resultado.getString("dpto"),
                    resultado.getObject("horainicio", LocalTime.class),
                    resultado.getObject("horacierre", LocalTime.class)
                );
            } else {
                throw new ProveedorNoEncontradoExcepcion();
            }
        }
        finally {
            consulta.close();
            resultado.close();
        }
    }

    public void crear(String nombres, String apellido, String mail, String contraseña,
        String calle, String numero, int cp, String piso, String dpto,
        String razonSocial, String horaInicio, String horaCierre, String ciudad, String telefono
        ) throws SQLException {
        try{
            conexion.setAutoCommit(false);
            var consulta = conexion.prepareStatement("INSERT INTO persona "
                + "(nombre, apellido,mail,contrasenia,tipopersona) VALUES (?, ?, ?, ?, ?)");
            consulta.setString(1, nombres);
            consulta.setString(2, apellido);
            consulta.setString(3, mail);
            consulta.setString(4, contraseña);
            consulta.setInt(5, 2);
            consulta.executeUpdate();        
            consulta.close();
    //recuperar el id de la bd
            var id = conexion.prepareStatement("SELECT (personaid) FROM persona"
                    + " WHERE nombre= ? AND apellido= ?");
            id.setString(1, nombres);
            id.setString(2, apellido);
            ResultSet rs = id.executeQuery();
            int idBD=0;
            while(rs.next()){
                idBD = rs.getInt("personaid");
            }
            id.close();
    //termino de recuperar el id

    //inserto en domicilio
            var consulta1 = conexion.prepareStatement("INSERT INTO direccion "
                + "(personaid,calle,numero,cp,piso,dpto) VALUES (?, ?, ?, ?, ?, ?)");
            consulta1.setInt(1,idBD);
            consulta1.setString(2,calle);
            consulta1.setString(3,numero);
            consulta1.setInt(4,cp);
            consulta1.setString(5,piso);
            consulta1.setString(6,dpto);
            consulta1.executeUpdate();
            consulta1.close();
    //inserto proveedor
            var consulta2 = conexion.prepareStatement("INSERT INTO proveedor "
                + "(proveedorid,razonsocial,horainicio,horacierre,ciudad,telefono)"
                + " VALUES (?, ?, ?, ?, ?, ?); ");
            consulta2.setInt(1,idBD);
            consulta2.setString(2,razonSocial);
            consulta2.setObject(3, LocalTime.parse(horaInicio, DateTimeFormatter.ISO_LOCAL_TIME));
            consulta2.setObject(4, LocalTime.parse(horaCierre, DateTimeFormatter.ISO_LOCAL_TIME));
            consulta2.setString(5,ciudad);
            consulta2.setString(6,telefono);
            consulta2.executeUpdate();
            consulta2.close();
    //termino
            conexion.commit();
        }catch(SQLException sqle){
        // imprimo el error
            System.out.println("Código de Error: " + sqle.getErrorCode() + "\n" +
                "SLQState: " + sqle.getSQLState() + "\n" +
                "Mensaje: " + sqle.getMessage() + "\n");
        conexion.rollback();
        }
    }

    public void modificar(ProveedorProducto proveedorproducto) throws SQLException, ProveedorNoEncontradoExcepcion {
//        try{
//            conexion.setAutoCommit(false);
        //persona
            var consulta = conexion.prepareStatement("UPDATE persona SET "
                    + " nombre = ?, apellido = ?, mail= ?, contrasenia= ?"
                    + " WHERE personaid= ?");
            consulta.setString(1, proveedorproducto.getNombre());
            consulta.setString(2, proveedorproducto.getApellido());
            consulta.setString(3, proveedorproducto.getMail());
            consulta.setString(4, proveedorproducto.getContraseña());
            consulta.setInt(5, proveedorproducto.getId());
            try {
                if (consulta.executeUpdate() == 0) throw new ProveedorNoEncontradoExcepcion();
            } finally {
                consulta.close();
            }
        //direccion.
            var consulta1 = conexion.prepareStatement("UPDATE direccion SET "
                    + " calle = ?, numero = ?, cp= ?, piso= ?, dpto= ?"
                    + " WHERE personaid= ?");
            consulta1.setString(1, proveedorproducto.getDireccion().getCalle());
            consulta1.setInt(2, proveedorproducto.getDireccion().getNumero());
            consulta1.setString(3, proveedorproducto.getDireccion().getCodigoPostal());
        //se cambio de int a string
            consulta1.setString(4, proveedorproducto.getDireccion().getPiso());
            consulta1.setString(5, proveedorproducto.getDireccion().getDepartamento());
            consulta1.setInt(6, proveedorproducto.getId());
            try {
                if (consulta1.executeUpdate() == 0) throw new ProveedorNoEncontradoExcepcion();
            } finally {
                consulta1.close();
            }
            var consulta2 = conexion.prepareStatement("UPDATE proveedor SET "
                    + " razonsocial= ?, horainicio= ?, horacierre= ?, ciudad= ?, telefono= ?"
                    + " WHERE proveedorid= ?");
            consulta2.setString(1, proveedorproducto.getRazonSocial());
            consulta2.setObject(2, proveedorproducto.getHoraInicio());
            consulta2.setObject(3, proveedorproducto.getHoraCierre());
            consulta2.setString(4, proveedorproducto.getCiudad());
            consulta2.setString(5, proveedorproducto.getTelefono());
            
            consulta2.setInt(6, proveedorproducto.getId());
            try {
                if (consulta2.executeUpdate() == 0) throw new ProveedorNoEncontradoExcepcion();
            } finally {
                consulta2.close();
            }

/*        }catch(SQLException sqle){
      // imprimo el error
            System.out.println("Código de Error: " + sqle.getErrorCode() + "\n" +
                "SLQState: " + sqle.getSQLState() + "\n" +
                "Mensaje: " + sqle.getMessage() + "\n");
//        conexion.rollback();
        }
*/    }

    public void borrar(ProveedorProducto proveedorproducto) throws SQLException, ProveedorNoEncontradoExcepcion {
        var consulta = conexion.prepareStatement("DELETE FROM persona WHERE personaid= ?;");
        consulta.setInt(1, proveedorproducto.getId());
       try {
            if (consulta.executeUpdate() == 0) throw new ProveedorNoEncontradoExcepcion();
        }
        finally {
            consulta.close();
        }
    }
}