import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class BottomUpIntegrationTest {

    @Test
    void integrateAllModules_throughUniversalConverter_distance() {
        UniversalConverter converter = new UniversalConverter();

        double actual = converter.convert(10, "Distance", "kilometer", "meter");

        assertEquals(10000.0, actual);
    }

    @Test
    void integrateAllModules_throughUniversalConverter_weight() {
        UniversalConverter converter = new UniversalConverter();

        double actual = converter.convert(1, "Weight", "kilogram", "gram");

        assertEquals(0.001, actual);
    }

    @Test
    void integrateAllModules_throughUniversalConverter_temperature() {
        UniversalConverter converter = new UniversalConverter();

        double actual = converter.convert(0, "Temperature", "C", "F");

        assertEquals(32.0, actual);
    }
}
