
import com.sebas.proyectomaven.Automovil;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sebas
 */
public class TestAutomovil {
    @Test
    public void testAcelerar () {
//testAcelerar() : Que verifique que el incremento de velocidad sea correcto, 
//considerando una potencia de 10.
        Automovil auto = new Automovil(10, "Fiat", "Uno");
        assertEquals(10, auto.acelerar(), "10 + 0 = 10");
    }
    
    @Test
    public void testFrenar () {
        Automovil auto = new Automovil(10, "Fiat", "Uno");
        auto.acelerar();
        auto.frenar();
        assertEquals(5,auto.getVelocidad(),"10 / 2 = 5");
    }
    
    @Test
    public void testFrenarTotalmente () {
        Automovil auto = new Automovil(10, "Fiat", "Uno");
        auto.acelerar();
    //10 /2= 5 /2=2 /2=1 /2= 0; CUATRO VECES HAY QUE FRENAR.
        auto.frenar(); // vel=5
        auto.frenar(); // vel=2
        auto.frenar(); // vel=1
        auto.frenar(); // vel=0
        assertEquals(0,auto.getVelocidad(),"Se frena 4 veces");
    }
}
