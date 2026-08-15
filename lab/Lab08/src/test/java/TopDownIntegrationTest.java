import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TopDownIntegrationTest {

    @Test
    void testUniversalConverter_dispatchesToDistanceStub() {
        DistanceConverterStub distance = new DistanceConverterStub();

        double actual = distance.convert(10, "kilometer", "meter");

        assertEquals(10000.0, actual);
    }

    @Test
    void testUniversalConverter_dispatchesToWeightStub() {
        WeightConverterStub weight = new WeightConverterStub();

        double actual = weight.convert(1, "kilogram", "lbs");

        assertEquals(1000, actual);
    }

    @Test
    void testUniversalConverter_dispatchesToTemperatureStub() {
        TemperatureConverterStub temp = new TemperatureConverterStub();
        double actual = temp.convert(100, "C", "F");

        assertEquals(212, actual);
    }
}
