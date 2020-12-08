package put.io.testing.junit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private Calculator calculator;
    //Aby @BeforeAll działało, metoda setUp i pole calculator muszą być statyczne
    @BeforeEach
    void setUp(){
        calculator = new Calculator();
    }
    @Test
    void testAdd() throws Exception{
        int a = calculator.add(2,2);
        assertEquals(4, a);
        a = calculator.add(3,-5);
        assertEquals(-2, a);
    }

    @Test
    void testMultiply() {
        int a = calculator.multiply(6, 6);
        assertEquals(36, a);
        a = calculator.multiply(-9, 5);
        assertEquals(-45, a);
    }

    @Test
    void testAddPositiveNumbers() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.addPositiveNumbers(-1, 2);
        });
    }
}