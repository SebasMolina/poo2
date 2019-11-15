/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;
import usuario.RepositorioUsuario;
import usuario.UsuarioNoEncontradoExcepcion;
import io.javalin.http.Context;
import java.sql.SQLException;

/**
 *
 * @author Axel
 */
public class UsuarioControlador {

    private final RepositorioUsuario RepositorioUsuario;

    public UsuarioControlador(RepositorioUsuario RepositorioUsuario) {
        this.RepositorioUsuario = RepositorioUsuario;
    }

    public void listar(Context ctx) throws SQLException {
        ctx.json(RepositorioUsuario.listar());
    }

    public void crear(Context ctx) throws SQLException {
        // Usando un formulario
        RepositorioUsuario.crear(ctx.formParam("nombres", String.class).get(), ctx.formParam("apellidos", String.class).get());        
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
        usuario.setNombreUsuario(ctx.formParam("nombres", String.class).get());
        usuario.setApellido(ctx.formParam("apellidos", String.class).get());
        RepositorioUsuario.modificar(usuario);
        ctx.status(204);
    }
}

