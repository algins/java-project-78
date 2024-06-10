package hexlet.code;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {
    public void testGetGreeting() {
        assertEquals(App.getGreeting(), "Hello world!");
    }
}
