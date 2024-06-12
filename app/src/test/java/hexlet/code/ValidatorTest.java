package hexlet.code;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

public class ValidatorTest {

    @Test
    public void testStringShema() {
        var validator = new Validator();
        var schema = validator.string();

        assertTrue(schema.isValid(""));
        assertTrue(schema.isValid(null));

        schema.required();
        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid(""));
        assertTrue(schema.isValid("what does the fox say"));
        assertTrue(schema.isValid("hexlet"));

        assertTrue(schema.contains("wh").isValid("what does the fox say"));
        assertTrue(schema.contains("what").isValid("what does the fox say"));
        assertFalse(schema.contains("whatthe").isValid("what does the fox say"));
        assertFalse(schema.isValid("what does the fox say"));

        var schema1 = validator.string();
        assertTrue(schema1.minLength(10).minLength(4).isValid("Hexlet"));
    }

    @Test
    public void testNumberSchema() {
        var validator = new Validator();
        var schema = validator.number();

        assertTrue(schema.isValid(5));
        assertTrue(schema.isValid(null));
        assertTrue(schema.positive().isValid(null));

        schema.required();
        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(10));
        assertFalse(schema.isValid(-10));
        assertFalse(schema.isValid(0));

        schema.range(5, 10);
        assertTrue(schema.isValid(5));
        assertTrue(schema.isValid(10));
        assertFalse(schema.isValid(4));
        assertFalse(schema.isValid(11));

        var schema1 = validator.number();
        assertTrue(schema1.range(4, 11).range(2, 13).isValid(12));
    }

    @Test
    public void testMapSchema() {
        var validator = new Validator();
        var schema = validator.map();
        var data = new HashMap<String, String>();

        assertTrue(schema.isValid(null));

        schema.required();
        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(new HashMap<>()));

        data.put("key1", "value1");
        assertTrue(schema.isValid(data));

        schema.sizeof(2);
        assertFalse(schema.isValid(data));

        data.put("key2", "value2");
        assertTrue(schema.isValid(data));

        data.put("key3", "value3");
        assertFalse(schema.isValid(data));

        data.remove("key3");
        assertTrue(schema.isValid(data));

        data.clear();
        assertFalse(schema.isValid(data));

        var schema1 = validator.map();
        var data1 = new HashMap<Integer, Integer>();

        data1.put(0, 1);
        assertTrue(schema1.isValid(data1));

        assertTrue(schema1.sizeof(2).sizeof(1).isValid(data1));
    }
}
