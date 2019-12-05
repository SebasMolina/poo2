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
import modelo.Usuario;
import excepcion.UsuarioNoEncontradoExcepcion;
import java.sql.ResultSet;

/**
 *
 * @author Click
 */ 
public class RepositorioUsuario {
    private final Connection conexion;

    public RepositorioUsuario(Connection connection) throws SQLException {
        this.conexion = connection;
        var consulta = connection.createStatement();
        consulta.close();
    }

    public List<Usuario> listar() throws SQLException {
        var usuario = new ArrayList<Usuario>();
        var consulta = conexion.createStatement();
        var resultado = consulta.executeQuery("SELECT * FROM persona"
                + " INNER JOIN direccion ON persona.personaid=direccion.personaid"
                + " LEFT JOIN usuario ON persona.personaid=usuarioid WHERE tipopersona=1;");

        while (resultado.next()) {
            usuario.add(
                new Usuario(
                    resultado.getInt("usuarioid"),
                    resultado.getString("nombre"),
                    resultado.getString("apellido"),
                    resultado.getString("nombreusuario"),
                    resultado.getString("telefono"),
                    resultado.getString("calle"),
                    resultado.getInt("numero"),
                    resultado.getString("cp"),
                    resultado.getString("piso"),
                    resultado.getString("dpto")        
                )
            );
        }
        resultado.close();
        consulta.close();
        return usuario;
    }

    public Usuario obtener(int identificador) throws SQLException, UsuarioNoEncontradoExcepcion {
        var consulta = conexion.prepareStatement("SELECT * FROM persona"
                + " INNER JOIN direccion ON persona.personaid=direccion.personaid"
                + " LEFT JOIN usuario ON persona.personaid=usuarioid "
                + "WHERE tipopersona=1 AND usuarioid= ?");
        consulta.setInt(1, identificador);
        var resultado = consulta.executeQuery();
        try {
            if (resultado.next()) {
                return new Usuario(
//aca va el constructor con todos los parametros
                    resultado.getInt("usuarioid"),
                    resultado.getString("nombre"),
                    resultado.getString("apellido"),
                    resultado.getString("mail"),
                    resultado.getString("contrasenia"),
                    resultado.getString("nombreusuario"),
                    resultado.getString("telefono"),
                    resultado.getString("calle"),
                    resultado.getInt("numero"),
                    resultado.getString("cp"),
                    resultado.getString("piso"),
                    resultado.getString("dpto")
                );
            } else {
                throw new UsuarioNoEncontradoExcepcion();
            }
        }
        finally {
            consulta.close();
            resultado.close();
        }
    }

public void crear(String nombre, String apellido, String mail, String contraseña,
        String calle, String numero, String cp, String piso, String dpto,
        String nombreUsuario, String telefono
        ) throws SQLException {
        try{
            conexion.setAutoCommit(false);
            var consulta = conexion.prepareStatement("INSERT INTO persona "
                + "(nombre, apellido,mail,contrasenia,tipopersona) VALUES (?, ?, ?, ?, ?)");
            consulta.setString(1, nombre);
            consulta.setString(2, apellido);
            consulta.setString(3, mail);
            consulta.setString(4, contraseña);
            consulta.setInt(5, 1);
            consulta.executeUpdate();        
            consulta.close();
    //recuperar el id de la bd
            var id = conexion.prepareStatement("SELECT (personaid) FROM persona"
                    + " WHERE nombre= ? AND apellido= ?");
            id.setString(1, nombre);
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
            consulta1.setString(4,cp);
            consulta1.setString(5,piso);
            consulta1.setString(6,dpto);
            consulta1.executeUpdate();
            consulta1.close();
    //inserto usuario
            var consulta2 = conexion.prepareStatement("INSERT INTO usuario "
                + "(usuarioid,nombreusuario,telefono)"
                + " VALUES (?, ?, ?); ");
            consulta2.setInt(1,idBD);
            consulta2.setString(2,nombreUsuario);
            consulta2.setString(3,telefono);
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

    public void modificar(Usuario usuario) throws SQLException, UsuarioNoEncontradoExcepcion {
//        try{
//            conexion.setAutoCommit(false);
        //persona
            var consulta = conexion.prepareStatement("UPDATE persona SET "
                    + " nombre = ?, apellido = ?, mail= ?, contrasenia= ?"
                    + " WHERE personaid= ?");
            consulta.setString(1, usuario.getNombre());
            consulta.setString(2, usuario.getApellido());
            consulta.setString(3, usuario.getMail());
            consulta.setString(4, usuario.getContraseña());
            consulta.setInt(5, usuario.getId());
            try {
                if (consulta.executeUpdate() == 0) throw new UsuarioNoEncontradoExcepcion();
            } finally {
                consulta.close();
            }
        //direccion.
            var consulta1 = conexion.prepareStatement("UPDATE direccion SET "
                    + " calle = ?, numero = ?, cp= ?, piso= ?, dpto= ?"
                    + " WHERE personaid= ?");
            consulta1.setString(1, usuario.getDireccion().getCalle());
            consulta1.setInt(2, usuario.getDireccion().getNumero());
            consulta1.setString(3, usuario.getDireccion().getCodigoPostal());
        //se cambio de int a string
            consulta1.setString(4, usuario.getDireccion().getPiso());
            consulta1.setString(5, usuario.getDireccion().getDepartamento());
            consulta1.setInt(6, usuario.getId());
            try {
                if (consulta1.executeUpdate() == 0) throw new UsuarioNoEncontradoExcepcion();
            } finally {
                consulta1.close();
            }
            var consulta2 = conexion.prepareStatement("UPDATE usuario SET "
                    + " nombreusuario= ?, telefono= ?"
                    + " WHERE proveedorid= ?");
            consulta2.setString(1, usuario.getNombreUsuario());
            consulta2.setString(5, usuario.getTelefono());
            consulta2.setInt(6, usuario.getId());
            try {
                if (consulta2.executeUpdate() == 0) throw new UsuarioNoEncontradoExcepcion();
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

    public void borrar(Usuario usuario) throws SQLException, UsuarioNoEncontradoExcepcion {
        var consulta = conexion.prepareStatement("DELETE FROM persona WHERE personaid= ?;");
        consulta.setInt(1, usuario.getId());
       try {
            if (consulta.executeUpdate() == 0) throw new UsuarioNoEncontradoExcepcion();
        }
        finally {
            consulta.close();
        }
    }
}