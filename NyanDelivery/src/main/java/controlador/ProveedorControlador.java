/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author Click
 */
import repositorio.RepositorioProveedorProducto;
import excepcion.ProveedorNoEncontradoExcepcion;
import io.javalin.http.Context;
import java.sql.SQLException;
import excepcion.ProveedorNoEncontradoExcepcion;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import modelo.Direccion;

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
    
    public void obtener(Context ctx) throws SQLException, ProveedorNoEncontradoExcepcion {
        ctx.json(RepositorioProveedorProducto.obtener(ctx.pathParam("identificador", Integer.class).get()));
    }
    
    public void crear(Context ctx) throws SQLException {
        // Usando un formulario
        RepositorioProveedorProducto.crear(
        //-----persona
            ctx.formParam("nombre", String.class).get(), 
            ctx.formParam("apellido", String.class).get(),
            ctx.formParam("mail", String.class).get(),
            ctx.formParam("contraseña", String.class).get(),

            //-----direccion
            ctx.formParam("calle", String.class).get(),
            ctx.formParam("numero", String.class).get(),
            ctx.formParam("cp", int.class).get(),
            ctx.formParam("piso", String.class).get(),
            ctx.formParam("dpto", String.class).get(),
        //-----proveedor
            ctx.formParam("razonSocial", String.class).get(),
            ctx.formParam("horaInicio", String.class).get(),
            ctx.formParam("horaCierre", String.class).get(),
            ctx.formParam("ciudad", String.class).get(),
            ctx.formParam("telefono", String.class).get()

            );        
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
        //usando un formulario.

    //-----persona
        proveedorproducto.setNombre(ctx.formParam("nombre", String.class).get()); 
        proveedorproducto.setApellido(ctx.formParam("apellido", String.class).get());
        proveedorproducto.setMail(ctx.formParam("mail", String.class).get());
        proveedorproducto.setContraseña(ctx.formParam("contraseña", String.class).get());
    //-----direccion
        proveedorproducto.setDireccion(new Direccion(
            ctx.formParam("calle", String.class).get(),
            ctx.formParam("numero", int.class).get(),
            ctx.formParam("cp", String.class).get(),
            ctx.formParam("piso", String.class).get(),
            ctx.formParam("dpto", String.class).get()));
    //-----proveedor
        proveedorproducto.setRazonSocial(ctx.formParam("razonSocial", String.class).get());
        proveedorproducto.setHoraInicio(LocalTime.parse(
                ctx.formParam("horaInicio", String.class).get(),DateTimeFormatter.ISO_LOCAL_TIME));
        proveedorproducto.setHoraCierre(LocalTime.parse(
                ctx.formParam("horaCierre", String.class).get(),DateTimeFormatter.ISO_LOCAL_TIME));
        proveedorproducto.setCiudad(ctx.formParam("ciudad", String.class).get());
        proveedorproducto.setTelefono(ctx.formParam("telefono", String.class).get());
    //termino y mando a repositorio para que modifique    
        RepositorioProveedorProducto.modificar(proveedorproducto);
        ctx.status(204);
    }
}

