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
        consulta.execute("CREATE TABLE IF NOT EXISTS usuario (usuarioid SERIAL PRIMARY KEY , nombreusuario TEXT, apellidos TEXT)");
        consulta.close();
    }

    public List<Usuario> listar() throws SQLException {
        var usuario = new ArrayList<Usuario>();
        var consulta = conexion.createStatement();
        var resultado = consulta.executeQuery("SELECT usuarioid, nombreusuario, apellidos FROM usuario");
        while (resultado.next()) {
            usuario.add(
                new Usuario(
                    resultado.getInt("usuarioid"),
                    resultado.getString("nombreusuario"),
                    resultado.getString("apellidos")
                )
            );
        }
        resultado.close();
        consulta.close();
        return usuario;
    }

    public Usuario obtener(int identificador) throws SQLException, UsuarioNoEncontradoExcepcion {
        var consulta = conexion.prepareStatement("SELECT usuarioid, nombresusuario, apellidos FROM usuario WHERE identificador = ?");
        consulta.setInt(1, identificador);
        var resultado = consulta.executeQuery();
        try {
            if (resultado.next()) {
                return new Usuario(
                        resultado.getInt("usuarioid"),
                        resultado.getString("nombreusuario"),
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

    public void crear(String nombreusuario, String apellidos) throws SQLException {
        try (java.sql.PreparedStatement consulta = conexion.prepareStatement("INSERT INTO usuario(nombreusuario, apellidos) VALUES (?, ?)")) {
            consulta.setString(1, nombreusuario);
            consulta.setString(2, apellidos);
            consulta.executeUpdate();
        }
    }

    public void modificar(Usuario usuario) throws SQLException, UsuarioNoEncontradoExcepcion {
        var consulta = conexion.prepareStatement("UPDATE usuario SET nombreusuario = ?, apellidos = ? WHERE usuarioid = ?");
        consulta.setInt(1, usuario.getId());
        consulta.setString(2, usuario.getNombreUsuario());
        consulta.setString(3, usuario.getApellido());
        
        try {
            if (consulta.executeUpdate() == 0) throw new UsuarioNoEncontradoExcepcion();
        }
        finally {
            consulta.close();
        }
    }

    public void borrar(Usuario usuario) throws SQLException, UsuarioNoEncontradoExcepcion {
        var consulta = conexion.prepareStatement("DELETE FROM usuario WHERE usuarioid = ?");
        consulta.setInt(1, usuario.getId());
       try {
            if (consulta.executeUpdate() == 0) throw new UsuarioNoEncontradoExcepcion();
        }
        finally {
            consulta.close();
        }
    }    
}

