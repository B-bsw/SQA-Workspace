package sqa.lab;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestShiftCipher {
    private final ShiftCipher shiftCipher = new ShiftCipher();

    @Test
    void testShiftCipher() {
        assertEquals("BCD", shiftCipher.shift("ABC", 1));
    }


}
