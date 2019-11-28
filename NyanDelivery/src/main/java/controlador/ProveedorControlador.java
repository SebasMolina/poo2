/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author Axel
 */
import repositorio.RepositorioProveedorProducto;
import excepcion.ProveedorNoEncontradoExcepcion;
import io.javalin.http.Context;
import java.sql.SQLException;
import excepcion.ProveedorNoEncontradoExcepcion;

/**
 *
 * @author Axel
 */
public class ProveedorControlador {

    private final RepositorioProveedorProducto RepositorioProveedorProducto;

    public ProveedorControlador(RepositorioProveedorProducto RepositorioProveedorProducto) {
        this.RepositorioProveedorProducto = RepositorioProveedorProducto;
    }

    public void listar(Context ctx) throws SQLException {
        ctx.json(RepositorioProveedorProducto.listar());
    }

    public void crear(Context ctx) throws SQLException {
        // Usando un formulario
        RepositorioProveedorProducto.crear(ctx.formParam("nombres", String.class).get(), ctx.formParam("apellidos", String.class).get());        
        // Usando JSON        
        /*
        var p = ctx.bodyAsClass(Persona.class);            
        personasRepositorio.crear(p.getNombres(), p.getApellidos());
        */
        ctx.status(201);
    }

    public void borrar(Context ctx) throws SQLException, ProveedorNoEncontradoExcepcion {
        RepositorioProveedorProducto.borrar(RepositorioProveedorProducto.obtener(ctx.pathParam("identificador", Integer.class).get()));
        ctx.status(204);
    }

    public void modificar(Context ctx) throws SQLException, ProveedorNoEncontradoExcepcion {
        var proveedorproducto = RepositorioProveedorProducto.obtener(ctx.pathParam("identificador", Integer.class).get());
        proveedorproducto.setNombre(ctx.formParam("nombres", String.class).get());
        proveedorproducto.setApellido(ctx.formParam("apellidos", String.class).get());
        RepositorioProveedorProducto.modificar(proveedorproducto);
        ctx.status(204);
    }
}

