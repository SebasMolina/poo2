
import com.sebas.proyectomaven.Calculadora;
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
public class CalculadoraTest {
    
    @Test
    public void testSuma () {
    // creo un objeto sobre el que quiero realizar una prueba
    Calculadora calculadora = new Calculadora();
    // Directivas de aserción o afirmación
    assertEquals(10, calculadora.sumar(7, 3), "7 + 3 = 10");
    }
 
}
