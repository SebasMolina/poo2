/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import excepcion.IngredienteNoEncontradoExcepcion;
import repositorio.RepositorioIngrediente;
import io.javalin.http.Context;
import java.sql.SQLException;

/**
 *
 * @author sebas
 */
public class IngredienteControlador {
    private final RepositorioIngrediente RepositorioIngrediente;

    public IngredienteControlador(RepositorioIngrediente RepositorioIngrediente) {
        this.RepositorioIngrediente = RepositorioIngrediente;
    }

    public void listar(Context ctx) throws SQLException {
        ctx.json(RepositorioIngrediente.listar());
    }

    public void crear(Context ctx) throws SQLException {
        // Usando un formulario
        RepositorioIngrediente.crear(ctx.formParam("nombres", String.class).get(), ctx.formParam("cantidad", Integer.class ).get());        
        // Usando JSON        
        /*
        var p = ctx.bodyAsClass(Persona.class);            
        personasRepositorio.crear(p.getNombres(), p.getApellidos());
        */
        ctx.status(201);
    }

    public void borrar(Context ctx) throws SQLException, IngredienteNoEncontradoExcepcion {
        RepositorioIngrediente.borrar(RepositorioIngrediente.obtener(ctx.pathParam("identificador", Integer.class).get()));
        ctx.status(204);
    }

    public void modificar(Context ctx) throws SQLException, IngredienteNoEncontradoExcepcion {
        var proveedorproducto = RepositorioIngrediente.obtener(ctx.pathParam("identificador", Integer.class).get());
        proveedorproducto.setNombre(ctx.formParam("nombres", String.class).get());
        proveedorproducto.setCantidad(ctx.formParam("Cantidad", Integer.class).get());
        RepositorioIngrediente.modificar(proveedorproducto);
        ctx.status(204);
    }
}
