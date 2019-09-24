
import com.sebas.proyectomaven.Automovil;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
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
    
    public Automovil auto;
    
    /** Inicio.
     *  Lo que hace es instanciar el objeto por cada test.
     */
    @BeforeEach
    public void inicio () {
        System.out.println("Inicio de test...");
        auto = new Automovil(10, "Fiat", "Uno");
    }
    
    @Test
    public void testAcelerar () {
        /** testAcelerar().
         *  Que verifique que el incremento de velocidad sea correcto
         *  considerando una potencia de 10.
         */
        auto.acelerar();
        assertEquals(10, this.auto.getVelocidad(), "10 + 0 = 10");
    }
    
    @Test
    public void testFrenar () {
        /** testFrenar().
         *  Que verifique que cuando acelero con una potencia 10
         *  frene y nos de una velocidad de 5.
         */
        auto.acelerar();
        auto.frenar();
        assertEquals(5,auto.getVelocidad(),"10 / 2 = 5");
    }
    
    @Test
    public void testFrenarTotalmente () {
        
        auto.acelerar();
    //10 /2= 5 /2=2 /2=1 /2= 0; CUATRO VECES HAY QUE FRENAR.
        auto.frenar(); // vel=5
        auto.frenar(); // vel=2
        auto.frenar(); // vel=1
        auto.frenar(); // vel=0
        assertEquals(0,auto.getVelocidad(),"Se frena 4 veces");
    }
}
