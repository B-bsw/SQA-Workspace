import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.sqa.lab.ShiftCipher;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class TestShiftCipher {

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/ShiftCipherEncrypt.csv")
    @DisplayName("Test Encrypt")
    void shouldEncryptCorrectly(
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

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/ShiftCipher.csv")
    @DisplayName("Test Decrypt")
    void shouldDecryptCorrectly(
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
