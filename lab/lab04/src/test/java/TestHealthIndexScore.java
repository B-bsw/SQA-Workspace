import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.health.fitness.HealthIndexScore;
import org.junit.jupiter.api.ClassOrderer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestClassOrder;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

@TestClassOrder(ClassOrderer.OrderAnnotation.class)
@TestMethodOrder(OrderAnnotation.class)
public class TestHealthIndexScore {

    // Normal Boundary
    @Order(1)
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
        testingHealthIndexScore(tc, vo2Max, rhr, hrr, expectedResult);
    } // mvn test -Dtest=TestHealthIndexScore#testNormalBoundaryValue

    // Robustness
    @Order(2)
    @ParameterizedTest
    @CsvFileSource(
        files = "src/test/resources/Robustness.csv",
        numLinesToSkip = 1
    )
    @DisplayName("Robustness Testing")
    void testRobustness(
        String tc,
        int vo2Max,
        int rhr,
        int hrr,
        String expectedResult
    ) {
        testingHealthIndexScore(tc, vo2Max, rhr, hrr, expectedResult);
    } // mvn test -Dtest=TestHealthIndexScore#testRobustness

    private void testingHealthIndexScore(
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
