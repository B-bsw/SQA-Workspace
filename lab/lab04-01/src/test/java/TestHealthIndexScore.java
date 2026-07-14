import com.health.fitness.HealthIndexScore;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TestHealthIndexScore {
    HealthIndexScore healthIndexScore;

//    @BeforeEach
//    void setUp() throws Exception {
//        healthIndexScore = new HealthIndexScore();
//    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    @DisplayName("Normal Boundary Value")
    void testNormalBoundaryValue(){

    }

}
