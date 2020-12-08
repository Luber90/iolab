package put.io.testing.junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FailureOrErrorTest {
    @Test
    void test1(){
        assertEquals(4, -5);
    }
    @Test
    void test2(){
        assertEquals(4, 1/0);
    }
    @Test
    void test3(){
        try {
            assertEquals(4, -5);
        }
        catch(Throwable a) {
            System.out.println(a.getStackTrace());
        }
    }
}
