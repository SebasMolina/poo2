/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema;

import io.javalin.Javalin;
import java.sql.DriverManager;
import java.sql.SQLException;
import Usuario.UsuarioControlador;
import usuario.RepositorioUsuario;
import usuario.UsuarioNoEncontradaExcepcion;
import static io.javalin.apibuilder.ApiBuilder.*;
import io.javalin.core.event.EventListener;
import java.util.Properties;



public class Servidor {

    public static void main(String[] args) throws SQLException {
        
        var url = "jdbc:postgresql://localhost:5432/nyandelivery";
    //CAMBIAR POR CADA BASE DE DATOS.
        Properties props = new Properties();
        props.setProperty("user","postgres");
    //CAMBIAR POR CADA USUARIO DE LA BD.
        props.setProperty("password","sebas");
    //CAMBIAR POR CADA CONTRASEÑA DE LA BASE DE DATOS
        var conexion = DriverManager.getConnection(url,props);
        var RepositorioUsuario = new RepositorioUsuario(conexion);
        var UsuarioControlador = new UsuarioControlador(RepositorioUsuario);

        Javalin.create()
        .events((EventListener event) -> {
            event.serverStopped(() -> { conexion.close(); });
        })
        .routes(() -> {
            path("Usuarios", () -> {
                get(UsuarioControlador::listar);
                post(UsuarioControlador::crear);
                path(":identificador", () -> {
                    delete(UsuarioControlador::borrar);
                    put(UsuarioControlador::modificar);
                });
            });
        })
        .exception(UsuarioNoEncontradaExcepcion.class, (e, ctx) -> { ctx.status(404); })
        .start(7000);
    }
}

