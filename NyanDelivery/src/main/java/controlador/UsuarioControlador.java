/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import repositorio.RepositorioUsuario;
import excepcion.UsuarioNoEncontradoExcepcion;
import io.javalin.http.Context;
import java.sql.SQLException;
import excepcion.UsuarioNoEncontradoExcepcion;
import modelo.Direccion;

/**
 *
 * @author Click
 */
public class UsuarioControlador {

    private final RepositorioUsuario RepositorioUsuario;

    public UsuarioControlador(RepositorioUsuario RepositorioUsuario) {
        this.RepositorioUsuario = RepositorioUsuario;
    }

    public void listar(Context ctx) throws SQLException {
        ctx.json(RepositorioUsuario.listar());
    }

    public void obtener(Context ctx) throws SQLException, UsuarioNoEncontradoExcepcion {
        ctx.json(RepositorioUsuario.obtener(ctx.pathParam("identificador", Integer.class).get()));
    }
    
    public void crear(Context ctx) throws SQLException {
        // Usando un formulario
        RepositorioUsuario.crear(
        //-----persona
            ctx.formParam("nombre", String.class).get(), 
            ctx.formParam("apellido", String.class).get(),
            ctx.formParam("mail", String.class).get(),
            ctx.formParam("contraseña", String.class).get(),
        //-----direccion
            ctx.formParam("calle", String.class).get(),
            ctx.formParam("numero", String.class).get(),
            ctx.formParam("cp", String.class).get(),
            ctx.formParam("piso", String.class).get(),
            ctx.formParam("dpto", String.class).get(),
        //-----usuario
            ctx.formParam("nombreusuario",String.class).get(),
            ctx.formParam("telefono", String.class).get());
        // Usando JSON        
        /*
        var p = ctx.bodyAsClass(Persona.class);            
        personasRepositorio.crear(p.getNombres(), p.getApellidos());
        */
        ctx.status(201);
    }
    
    public void borrar(Context ctx) throws SQLException, UsuarioNoEncontradoExcepcion {
        RepositorioUsuario.borrar(RepositorioUsuario.obtener(ctx.pathParam("identificador", Integer.class).get()));
        ctx.status(204);
    }

    public void modificar(Context ctx) throws SQLException, UsuarioNoEncontradoExcepcion {
        var usuario = RepositorioUsuario.obtener(ctx.pathParam("identificador", Integer.class).get());
    // usando un formulario
    //-----persona
        usuario.setNombre(ctx.formParam("nombre", String.class).get()); 
        usuario.setApellido(ctx.formParam("apellido", String.class).get());
        usuario.setMail(ctx.formParam("mail", String.class).get());
        usuario.setContraseña(ctx.formParam("contraseña", String.class).get());
    //-----direccion
        usuario.setDireccion(new Direccion(
            ctx.formParam("calle", String.class).get(),
            ctx.formParam("numero", int.class).get(),
            ctx.formParam("cp", String.class).get(),
            ctx.formParam("piso", String.class).get(),
            ctx.formParam("dpto", String.class).get()));
    //-----usuario
        usuario.setNombreUsuario(ctx.formParam("nombreusuario", String.class).get());
        usuario.setTelefono(ctx.formParam("telefono", String.class).get());
    //termino y mando a repositorio para que modifique    
        RepositorioUsuario.modificar(usuario);
        ctx.status(204);
    }    

}

