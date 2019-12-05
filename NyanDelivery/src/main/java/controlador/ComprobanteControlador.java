/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import excepcion.ComprobanteNoEncontradoExcepcion;
import io.javalin.http.Context;
import java.sql.SQLException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import repositorio.RepositorioComprobante;

/**
 *
 * @author sebas
 */
public class ComprobanteControlador {
    
    private final RepositorioComprobante repositorioComprobante;

    public ComprobanteControlador(RepositorioComprobante RepositorioComprobante) {
        this.repositorioComprobante = RepositorioComprobante;
    }

    public void listar(Context ctx) throws SQLException {
        ctx.json(repositorioComprobante.listar());
    }
    
    public void obtener(Context ctx) throws SQLException, ComprobanteNoEncontradoExcepcion {
        ctx.json(repositorioComprobante.obtener(ctx.pathParam("identificador", Integer.class).get()));
    }
    
    public void obtenerPorProveedor(Context ctx) throws SQLException, ComprobanteNoEncontradoExcepcion {
        ctx.json(repositorioComprobante.obtenerPorProveedor(ctx.pathParam("proveedor", String.class).get()));
    }
    
    public void crear(Context ctx) throws SQLException {
        // Usando un formulario
        repositorioComprobante.crear(
        //-----persona
            ctx.formParam("proveedorid", int.class).get(), 
            ctx.formParam("usuarioid", int.class).get(),
            ctx.formParam("pedidoid", int.class).get(),
            ctx.formParam("total", Double.class).get()
            );        
        // Usando JSON        
        /*
        var p = ctx.bodyAsClass(Persona.class);            
        personasRepositorio.crear(p.getNombres(), p.getApellidos());
        */
        ctx.status(201);
    }

  
}
