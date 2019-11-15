/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proveedorproducto;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Axel
 */
public class RepositorioProveedorProducto {
    private final Connection conexion;

    public RepositorioProveedorProducto(Connection connection) throws SQLException {
        this.conexion = connection;
        var consulta = connection.createStatement();
        consulta.execute("CREATE TABLE IF NOT EXISTS proveedorproducto (identificador SERIAL PRIMARY KEY , nombres TEXT, apellidos TEXT)");
        consulta.close();
    }

    public List<ProveedorProducto> listar() throws SQLException {
        var proveedorproducto = new ArrayList<ProveedorProducto>();
        var consulta = conexion.createStatement();
        var resultado = consulta.executeQuery("SELECT identificador, nombres, apellidos FROM personas");
        while (resultado.next()) {
            proveedorproducto.add(
                new ProveedorProducto(
                    resultado.getInt("identificador"),
                    resultado.getString("nombres"),
                    resultado.getString("apellidos")
                )
            );
        }
        resultado.close();
        consulta.close();
        return proveedorproducto;
    }

    public ProveedorProducto obtener(int identificador) throws SQLException, ProveedorNoEncontradoExcepcion {
        var consulta = conexion.prepareStatement("SELECT identificador, nombres, apellidos FROM personas WHERE identificador = ?");
        consulta.setInt(1, identificador);
        var resultado = consulta.executeQuery();
        try {
            if (resultado.next()) {
                return new ProveedorProducto(
                        resultado.getInt("identificador"),
                        resultado.getString("nombres"),
                        resultado.getString("apellidos")
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

    public void crear(String nombres, String apellidos) throws SQLException {
        var consulta = conexion.prepareStatement("INSERT INTO personas (nombres, apellidos) VALUES (?, ?)");
        consulta.setString(1, nombres);
        consulta.setString(2, apellidos);
        consulta.executeUpdate();        
        consulta.close();
    }

    public void modificar(ProveedorProducto proveedorproducto) throws SQLException, ProveedorNoEncontradoExcepcion {
        var consulta = conexion.prepareStatement("UPDATE personas SET nombres = ?, apellidos = ? WHERE identificador = ?");
        consulta.setString(1, proveedorproducto.getNombre());
        consulta.setString(2, proveedorproducto.getApellido());
        consulta.setInt(3, proveedorproducto.getId());
        try {
            if (consulta.executeUpdate() == 0) throw new ProveedorNoEncontradoExcepcion();
        }
        finally {
            consulta.close();
        }
    }

    public void borrar(ProveedorProducto proveedorproducto) throws SQLException, ProveedorNoEncontradoExcepcion {
        var consulta = conexion.prepareStatement("DELETE FROM personas WHERE identificador = ?");
        consulta.setInt(1, proveedorproducto.getId());
       try {
            if (consulta.executeUpdate() == 0) throw new ProveedorNoEncontradoExcepcion();
        }
        finally {
            consulta.close();
        }
    }    
}

