package put.io.testing.audiobooks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AudiobookPriceCalculatorTest {
    @Test
    void testCalculate() {
        Customer customer1 = new Customer("Test", Customer.LoyaltyLevel.STANDARD, false);
        Customer customer2 = new Customer("Test", Customer.LoyaltyLevel.STANDARD, true);
        Customer customer3 = new Customer("Test", Customer.LoyaltyLevel.SILVER, false);
        Customer customer4 = new Customer("Test", Customer.LoyaltyLevel.GOLD, false);
        Audiobook audiobook = new Audiobook("test", 100);
        AudiobookPriceCalculator calc = new AudiobookPriceCalculator();
        assertEquals(100.0, calc.calculate(customer1, audiobook));
        assertEquals(0.0, calc.calculate(customer2, audiobook));
        assertEquals(90.0, calc.calculate(customer3, audiobook));
        assertEquals(80.0, calc.calculate(customer4, audiobook));
    }
}