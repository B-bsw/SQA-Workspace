import com.health.fitness.HealthIndexScore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestNormalBoundary {

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/NormalBoundary.csv")
    @DisplayName("Normal Boundary Value Testing")
    void testNormalBoundaryValue(
        String tc,
        int vo2Max,
        int rhr,
        int hrr,
        String expectedResult
    ) {
        if (expectedResult.equals("Invalid")) {
            assertThrows(IllegalArgumentException.class, () ->
                new HealthIndexScore(vo2Max, rhr, hrr)
            );

            System.out.println(tc + " " + expectedResult);
        } else {
            assertEquals(
                expectedResult,
                new HealthIndexScore(vo2Max, rhr, hrr)
                    .getFitnessLevel()
                    .toString()
            );

            System.out.println(
                tc +
                    " " +
                    new HealthIndexScore(vo2Max, rhr, hrr).getFitnessLevel()
            );
        }
    }
}
