import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.sqa.lab.ShiftCipher;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

@TestClassOrder(ClassOrderer.OrderAnnotation.class)
@TestMethodOrder(OrderAnnotation.class)
public class TestShiftCipher {

    @Order(1)
    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/ShiftCipherEncrypt.csv")
    @DisplayName("Test ShiftCipher Encrypt")
    void Encrypt(
            String input,
            int key,
            String expected
    ) {
        ShiftCipher cipher = new ShiftCipher();

        if ("INVALID".equals(expected)) {
            assertThrows(IllegalArgumentException.class, () ->
                    cipher.encrypt(input, key)
            );
        } else {
            assertEquals(expected, cipher.encrypt(input, key));
        }
    }

    @Order(2)
    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/ShiftCipherDecrypt.csv")
    @DisplayName("Test ShiftCipher Decrypt")
    void Decrypt(
            String input,
            int key,
            String expected
    ) {
        ShiftCipher cipher = new ShiftCipher();

        if ("INVALID".equals(expected)) {
            assertThrows(IllegalArgumentException.class, () ->
                    cipher.decrypt(input, key)
            );
        } else {
            assertEquals(expected, cipher.decrypt(input, key));
        }
    }
}
