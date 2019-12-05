/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorio;

import modelo.Ingrediente;
import excepcion.IngredienteNoEncontradoExcepcion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sebas
 */
public class RepositorioIngrediente {
    private final Connection conexion;

    public RepositorioIngrediente(Connection connection) throws SQLException {
        this.conexion = connection;
        var consulta = connection.createStatement();
        consulta.close();
    }

    public List<Ingrediente> listar() throws SQLException {
        var ingrediente = new ArrayList<Ingrediente>();
        var consulta = conexion.createStatement();
        var resultado = consulta.executeQuery("SELECT * FROM ingrediente");
        while (resultado.next()) {
            ingrediente.add(
                new Ingrediente(
                    resultado.getInt("ingredienteid"),
                    resultado.getString("nombre"),
                    resultado.getInt("cantidad")
                )
            );
        }
        resultado.close();
        consulta.close();
        return ingrediente;
    }

    public Ingrediente obtener(int identificador) throws SQLException, IngredienteNoEncontradoExcepcion {
        var consulta = conexion.prepareStatement("SELECT * FROM personas WHERE ingredienteid = ?");
        consulta.setInt(1, identificador);
        var resultado = consulta.executeQuery();
        try {
            if (resultado.next()) {
                return new Ingrediente(
                        resultado.getInt("ingredienteid"),
                        resultado.getString("nombre"),
                        resultado.getInt("cantidad")
                );
            } else {
                throw new IngredienteNoEncontradoExcepcion();
            }
        }
        finally {
            consulta.close();
            resultado.close();
        }
    }

    public void crear(String nombre, Integer cantidad) throws SQLException {
        try{
            conexion.setAutoCommit(false);
            var consulta = conexion.prepareStatement("INSERT INTO ingrediente (nombre, cantidad)"
                    + "VALUES (?, ?)");
        
            consulta.setString(1, nombre);
            consulta.setInt(2, cantidad);
            
            consulta.executeUpdate();        
            consulta.close();
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

    public void modificar(Ingrediente ingrediente) throws SQLException, IngredienteNoEncontradoExcepcion {
        var consulta = conexion.prepareStatement("UPDATE ingrediente SET "
            + "nombre = ?, cantidad = ?"
            + "WHERE ingredienteid = ?");
        consulta.setString(1, ingrediente.getNombre());
        consulta.setInt(2, ingrediente.getCantidad());
        consulta.setInt(3, ingrediente.getId());
        try {
            if (consulta.executeUpdate() == 0) throw new IngredienteNoEncontradoExcepcion();
        }
        finally {
            consulta.close();
        }
    }

    public void borrar(Ingrediente ingrediente) throws SQLException, IngredienteNoEncontradoExcepcion {
        var consulta = conexion.prepareStatement("DELETE FROM ingrediente WHERE ingredienteid= ?;");
        consulta.setInt(1, ingrediente.getId());
       try {
            if (consulta.executeUpdate() == 0) throw new IngredienteNoEncontradoExcepcion();
        }
        finally {
            consulta.close();
        }
    }   
}
