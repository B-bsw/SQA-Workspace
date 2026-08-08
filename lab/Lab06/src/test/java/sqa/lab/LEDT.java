package sqa.lab;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class LEDT {

    @ParameterizedTest
    @DisplayName("Test Case LEDT")
    @CsvFileSource(
        files = "src/test/resouces/TestCaseLEDT.csv",
        numLinesToSkip = 1,
        nullValues = "-"
    )
    public void TestLEDT(Integer a, Integer b, Integer c, String result) {
        if (result.equals("throw new IllegalArgumentException")) {
            assertThrows(IllegalArgumentException.class, () ->
                new QuadraticEquation().determineRootNature(a, b, c).toString()
            );
        } else {
            assertEquals(
                new QuadraticEquation().determineRootNature(a, b, c).toString(),
                result
            );
        }
    }
}
