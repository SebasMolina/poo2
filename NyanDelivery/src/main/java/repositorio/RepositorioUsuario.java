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

/**
 *
 * @author Axel
 */ 
//import NyanDelivery.SeurcePackages.modelo.Usuario;

/**
 *
 * @author CM
 */
public class RepositorioUsuario {
    private final Connection conexion;

    public RepositorioUsuario(Connection connection) throws SQLException {
        this.conexion = connection;
        var consulta = connection.createStatement();
        consulta.execute("CREATE TABLE IF NOT EXISTS usuarios (identificador SERIAL PRIMARY KEY , nombres TEXT, apellidos TEXT)");
        consulta.close();
    }

    public List<Usuario> listar() throws SQLException {
        var usuario = new ArrayList<Usuario>();
        var consulta = conexion.createStatement();
        var resultado = consulta.executeQuery("SELECT identificador, nombres, apellidos FROM usuarios");
        while (resultado.next()) {
            usuario.add(
                new Usuario(
                    resultado.getInt("identificador"),
                    resultado.getString("nombres"),
                    resultado.getString("apellidos")
                )
            );
        }
        resultado.close();
        consulta.close();
        return usuario;
    }

    public Usuario obtener(int identificador) throws SQLException, UsuarioNoEncontradoExcepcion {
        var consulta = conexion.prepareStatement("SELECT identificador, nombres, apellidos FROM usuarios WHERE identificador = ?");
        consulta.setInt(1, identificador);
        var resultado = consulta.executeQuery();
        try {
            if (resultado.next()) {
                return new Usuario(
                        resultado.getInt("identificador"),
                        resultado.getString("nombres"),
                        resultado.getString("apellidos")
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

    public void crear(String nombres, String apellidos) throws SQLException {
        try (java.sql.PreparedStatement consulta = conexion.prepareStatement("INSERT INTO usuario(nombres, apellidos) VALUES (?, ?)")) {
            consulta.setString(1, nombres);
            consulta.setString(2, apellidos);
            consulta.executeUpdate();
        }
    }

    public void modificar(Usuario usuario) throws SQLException, UsuarioNoEncontradoExcepcion {
        var consulta = conexion.prepareStatement("UPDATE usuario SET nombres = ?, apellidos = ? WHERE identificador = ?");
        consulta.setString(1, usuario.getNombreUsuario());
        consulta.setString(2, usuario.getApellido());
        consulta.setInt(3, usuario.getId());
        try {
            if (consulta.executeUpdate() == 0) throw new UsuarioNoEncontradoExcepcion();
        }
        finally {
            consulta.close();
        }
    }

    public void borrar(Usuario usuario) throws SQLException, UsuarioNoEncontradoExcepcion {
        var consulta = conexion.prepareStatement("DELETE FROM usuarios WHERE identificador = ?");
        consulta.setInt(1, usuario.getId());
       try {
            if (consulta.executeUpdate() == 0) throw new UsuarioNoEncontradoExcepcion();
        }
        finally {
            consulta.close();
        }
    }    
}

