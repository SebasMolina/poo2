/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema;

import io.javalin.Javalin;
import java.sql.DriverManager;
import java.sql.SQLException;
import usuario.controlador.UsuarioControlador;
import modelo.RepositorioUsuario;
import modelo.UsuarioNoEncontradaExcepcion;
import static io.javalin.apibuilder.ApiBuilder.*;
import io.javalin.core.event.EventListener;
import java.util.Properties;



public class Servidor {

    public static void main(String[] args) throws SQLException {
        
        String url = "jdbc:posgresql://localhost:5432/nyamdelivery";
        Properties props = new Properties();
        props.setProperty("user","postgres");
        props.setProperty("password","37704997");
        props.setProperty("ssl","true");
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

