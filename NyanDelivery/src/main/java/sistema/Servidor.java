/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema;
import io.javalin.Javalin;

/**
 *
 * @author sebas
 */
public class NewClass {
    

    public static void main(String[] args) {
        Javalin app = Javalin.create().start(7000);
        app.get("/", ctx -> ctx.result("Hello World"));
        //app.post("/proveedor", asdfasdf);
    }
}

