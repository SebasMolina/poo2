/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorio;

import excepcion.ComprobanteNoEncontradoExcepcion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import modelo.Comprobante;

/**
 *
 * @author sebas
 */
public class RepositorioComprobante {
    private final Connection conexion;

    public RepositorioComprobante (Connection connection) throws SQLException {
        this.conexion = connection;
        var consulta = connection.createStatement();
        consulta.execute("");
        consulta.close();
    }  
      public List<Comprobante> listar() throws SQLException {
        var comprobante = new ArrayList<Comprobante>();
        var consulta = conexion.createStatement();
        var resultado = consulta.executeQuery("SELECT * FROM"
                + " comprobante INNER JOIN detallecomprobante on " +
                  "detallecomprobante.detalleid = comprobante.detalleid;");
        
        while (resultado.next()) {
            comprobante.add(
                new Comprobante(
                    resultado.getInt("comprobanteid"),
                    resultado.getInt("proveedorid"),
                    resultado.getInt("usuarioid"),
                    resultado.getObject("hora", LocalTime.class),
                    resultado.getInt("detalleid"),
                    resultado.getDouble("total"),
                    resultado.getInt("pedidoid")
                )
            );
        }
        resultado.close();
        consulta.close();
        return comprobante;
      }
      
       public Comprobante obtener(int identificador) throws SQLException, ComprobanteNoEncontradoExcepcion {
        var consulta = conexion.prepareStatement("SELECT * FROM"
                + " comprobante INNER JOIN detallecomprobante ON detallecomprobante.detalleid = comprobante.detalleid "
                + " WHERE comprobanteid=?");
        consulta.setInt(1, identificador);
        var resultado = consulta.executeQuery();
        try {
            if (resultado.next()) {
                return new Comprobante(
                //aca va el constructor con todos los parametros
                    resultado.getInt("comprobanteid"),
                    resultado.getInt("proveedorid"),
                    resultado.getInt("usuarioid"),
                    resultado.getObject("hora", LocalTime.class),
                    resultado.getInt("detalleid"),
                    resultado.getDouble("total"),
                    resultado.getInt("pedidoid")
                );
            } else {
                throw new ComprobanteNoEncontradoExcepcion();
            }
        }
        finally {
            consulta.close();
            resultado.close();
        }
    }

    public void crear(int proveedorid, int usuarioid, int pedidoid, Double total
        ) throws SQLException {
        try{
            conexion.setAutoCommit(false);
            var consulta = conexion.prepareStatement("INSERT INTO detallecomprobante "
                + "(total, pedidoid) VALUES (?, ?)");
            consulta.setDouble(1, total);
            consulta.setInt(2, pedidoid);
            consulta.executeUpdate();        
            consulta.close();
    //recuperar el id de la bd
            var id = conexion.prepareStatement("SELECT (detalleid) FROM detallecomprobante"
                    + " WHERE total= ? AND pedidoid= ?");
            id.setDouble(1, total);
            id.setInt(2, pedidoid);
            ResultSet rs = id.executeQuery();
            int idBD=0;
            while(rs.next()){
                idBD = rs.getInt("detalleid");
            }
            id.close();
    //termino de recuperar el id

    
            var consulta2 = conexion.prepareStatement("INSERT INTO comprobante "
                + "(proveedorid,usuarioid,hora,detalleid)"
                + " VALUES (?, ?, ?, ?); ");
            consulta2.setInt(1,proveedorid);
            consulta2.setInt(2,usuarioid);
            consulta2.setObject(3, LocalTime.now());
            consulta2.setInt(4, idBD);
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

     public List<Comprobante> obtenerPorProveedor(String razonsocial) throws SQLException, ComprobanteNoEncontradoExcepcion {
        var comprobante = new ArrayList<Comprobante>();
        var consulta = conexion.prepareStatement("SELECT * FROM"
                + " comprobante INNER JOIN detallecomprobante ON detallecomprobante.detalleid = comprobante.detalleid"
                + " INNER JOIN proveedor ON proveedor.proveedorid = comprobante.comprobanteid"
                + " WHERE razonsocial=?");
        consulta.setString(1, razonsocial);
        var resultado = consulta.executeQuery();
        
            while (resultado.next()) {
                comprobante.add(
                    new Comprobante(
                    //aca va el constructor con todos los parametros
                        resultado.getInt("comprobanteid"),
                        resultado.getInt("proveedorid"),
                        resultado.getInt("usuarioid"),
                        resultado.getObject("hora", LocalTime.class),
                        resultado.getInt("detalleid"),
                        resultado.getDouble("total"),
                        resultado.getInt("pedidoid")
                    )
                );
            }
            resultado.close(); 
            return comprobante;
        }
     
}
