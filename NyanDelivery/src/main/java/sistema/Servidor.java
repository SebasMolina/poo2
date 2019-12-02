/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema;

import excepcion.IngredienteNoEncontradoExcepcion;
import excepcion.ProveedorNoEncontradoExcepcion;
import excepcion.UsuarioNoEncontradoExcepcion;
import controlador.IngredienteControlador;
import controlador.ProveedorControlador;
import controlador.UsuarioControlador;
import repositorio.RepositorioProveedorProducto;
import repositorio.RepositorioIngrediente;
import repositorio.RepositorioComprobante;
import repositorio.RepositorioUsuario;
import io.javalin.Javalin;
import java.sql.DriverManager;
import java.sql.SQLException;
import static io.javalin.apibuilder.ApiBuilder.*;
import io.javalin.core.event.EventListener;
import java.util.Properties;




public class Servidor {

    public static void main(String[] args) throws SQLException {
        
        var url = "jdbc:postgresql://localhost:5432/nyamdelivery";
    //CAMBIAR POR CADA BASE DE DATOS.
        Properties props = new Properties();
        props.setProperty("user","postgres");
    //CAMBIAR POR CADA USUARIO DE LA BD.
        props.setProperty("password","ax37704997");
    //CAMBIAR POR CADA CONTRASEÑA DE LA BASE DE DATOS
        var conexion = DriverManager.getConnection(url,props);
        var RepositorioUsuario = new RepositorioUsuario(conexion);
        var UsuarioControlador = new UsuarioControlador(RepositorioUsuario);
        var RepositorioProveedorProducto = new RepositorioProveedorProducto(conexion);
        var ProveedorControlador = new ProveedorControlador(RepositorioProveedorProducto);
        var RepositorioIngrediente = new RepositorioIngrediente(conexion);
        var IngredienteControlador = new IngredienteControlador(RepositorioIngrediente);
        var RepositorioComprobante = new RepositorioComprobante(conexion);
        
        
        Javalin.create(config -> {
            config.defaultContentType = "application/json";
            config.addStaticFiles("/public");
            config.enableCorsForAllOrigins();
            config.addSinglePageRoot("/", "/public/index.html");
        })
      
        .events((EventListener event) -> {
            event.serverStopped(() -> { conexion.close(); });
        })
        
        .routes(() -> {
            path("usuario", () -> {
                get(UsuarioControlador::listar);
                post(UsuarioControlador::crear);
                path(":identificador", () -> {
                    delete(UsuarioControlador::borrar);
                    put(UsuarioControlador::modificar);
                });
            });
            path("proveedor", () -> {
                get(ProveedorControlador::listar);
                post(ProveedorControlador::crear);
                path(":identificador", () -> {
                    delete(ProveedorControlador::borrar);
                    put(ProveedorControlador::modificar);
                });
            });
            path("ingrediente", () -> {
                get(IngredienteControlador::listar);
                post(IngredienteControlador::crear);
                path(":identificador", () -> {
                    delete(IngredienteControlador::borrar);
                    put(IngredienteControlador::modificar);
                });
            });
        })
        .exception(UsuarioNoEncontradoExcepcion.class, (e, ctx) -> { ctx.status(404); })
        .exception(ProveedorNoEncontradoExcepcion.class, (e, ctx) -> { ctx.status(404); })
        .exception(IngredienteNoEncontradoExcepcion.class, (e, ctx) -> { ctx.status(404); })
        .start(7000);
    }
}

