/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingrediente;

import java.sql.Connection;
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
        consulta.execute("CREATE TABLE IF NOT EXISTS ingredientes (identificador SERIAL PRIMARY KEY , nombres TEXT, cantidad INTEGER)");
        consulta.close();
    }

    public List<Ingrediente> listar() throws SQLException {
        var proveedorproducto = new ArrayList<Ingrediente>();
        var consulta = conexion.createStatement();
        var resultado = consulta.executeQuery("SELECT identificador, nombres, cantidad FROM ingredientes");
        while (resultado.next()) {
            proveedorproducto.add(
                new Ingrediente(
                    resultado.getInt("identificador"),
                    resultado.getString("nombres"),
                    resultado.getString("cantidad")
                )
            );
        }
        resultado.close();
        consulta.close();
        return proveedorproducto;
    }

    public Ingrediente obtener(int identificador) throws SQLException, IngredienteNoEncontradoExcepcion {
        var consulta = conexion.prepareStatement("SELECT identificador, nombres, cantidad FROM personas WHERE identificador = ?");
        consulta.setInt(1, identificador);
        var resultado = consulta.executeQuery();
        try {
            if (resultado.next()) {
                return new Ingrediente(
                        resultado.getInt("identificador"),
                        resultado.getString("nombres"),
                        resultado.getString("cantidad")
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

    public void crear(String nombres, Integer cantidad) throws SQLException {
        var consulta = conexion.prepareStatement("INSERT INTO personas (nombres, cantidad) VALUES (?, ?)");
        consulta.setString(1, nombres);
        consulta.setInt(2, cantidad);
        consulta.executeUpdate();        
        consulta.close();
    }

    public void modificar(Ingrediente ingrediente) throws SQLException, IngredienteNoEncontradoExcepcion {
        var consulta = conexion.prepareStatement("UPDATE personas SET nombres = ?, cantidad = ? WHERE identificador = ?");
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
        var consulta = conexion.prepareStatement("DELETE FROM personas WHERE identificador = ?");
        consulta.setInt(1, ingrediente.getId());
       try {
            if (consulta.executeUpdate() == 0) throw new IngredienteNoEncontradoExcepcion();
        }
        finally {
            consulta.close();
        }
    }   
}
