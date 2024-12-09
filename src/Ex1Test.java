import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Ex1Test {
    @Test
    void computeNumberTest() {
        String s2 = "1011b2";
        int v = Ex1.number2Int(s2);
        assertEquals(v, 11);
        String s10 = "1011bA";
        v = Ex1.number2Int(s10);
        s2 = Ex1.int2Number(v, 2);
        int v2 = Ex1.number2Int(s2);
        assertEquals(v, v2);
        assertTrue(Ex1.equals(s10, s2));
    }

    @Test
    void isBasisNumberTest() {
        String[] good = {"1", "1b2", "01b2", "123bA", "ABbG", "0bA"};
        for (int i = 0; i < good.length; i = i + 1) {
            boolean ok = Ex1.isNumber(good[i]);
            assertTrue(ok);
        }
        String[] not_good = {"b2", "2b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2"};
        for (int i = 0; i < not_good.length; i = i + 1) {
            boolean not_ok = Ex1.isNumber(not_good[i]);
            assertFalse(not_ok);
        }
    }

    @Test
    public void Int2NumberTest() {
        assertEquals("12b11", Ex1.int2Number(18, 11));
        assertEquals("1Bb16", Ex1.int2Number(27, 16));
        assertEquals("10b10", Ex1.int2Number(10, 10));
        assertEquals("1010b2", Ex1.int2Number(10, 2));

    }

    @Test
    public void testNumber2Int() {
        assertEquals(18, Ex1.number2Int("12b11"));
        assertEquals(27, Ex1.number2Int("1Bb16"));
        assertEquals(10, Ex1.number2Int("10"));
        assertEquals(-1, Ex1.number2Int("G12"));//invalid number
        assertEquals(-1, Ex1.number2Int("12b18"));//invalid base

    }

    @Test
    public void testIsNumber() {
        assertTrue(Ex1.isNumber("12b11"));
        assertTrue(Ex1.isNumber("1Bb16"));
        assertTrue(Ex1.isNumber("10"));
        assertFalse(Ex1.isNumber("G12")); // Invalid number
        assertFalse(Ex1.isNumber("12b18")); // Invalid base
        assertFalse(Ex1.isNumber("12bA")); // Invalid base character
    }

    @Test
    public void testBaseValue() {
        assertEquals(11, Ex1.BaseValue("12b11"));
        assertEquals(16, Ex1.BaseValue("1Bb16"));
        assertEquals(10, Ex1.BaseValue("10"));
        assertEquals(0, Ex1.BaseValue("G12")); // Invalid number
    }

    @Test
    public void testCharValue() {
        assertEquals(10, Ex1.CharValue('A'));
        assertEquals(11, Ex1.CharValue('B'));
        assertEquals(12, Ex1.CharValue('C'));
        assertEquals(13, Ex1.CharValue('D'));
        assertEquals(14, Ex1.CharValue('E'));
        assertEquals(15, Ex1.CharValue('F'));
        assertEquals(16, Ex1.CharValue('G'));
        assertEquals(0, Ex1.CharValue('Z')); // Invalid character
    }

    @Test
    public void testMaxIndex() {
        String[] values = {"12b11", "1Bb16", "10"};
        assertEquals(27, Ex1.maxIndex(values));
        String[] values2 = {"10b2", "5b2", "7b2"};
        assertEquals(10, Ex1.maxIndex(values2));
    }

    @Test
    public void testEquals() {
        assertTrue(Ex1.equals("12b11", "12b11"));
        assertFalse(Ex1.equals("12b11", "1Bb16"));
        assertFalse(Ex1.equals("12b11", "12b12"));
        assertTrue(Ex1.equals("10", "10"));
    }
}
