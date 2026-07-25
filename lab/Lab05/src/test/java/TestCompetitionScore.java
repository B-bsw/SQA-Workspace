import static org.junit.jupiter.api.Assertions.*;

import com.sqa.lab.CompetitionScore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class TestCompetitionScore {

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/CompetitionScore.csv")
    @DisplayName("Test CompetitionScore")
    void testFindMaxScore(
        String inputScore,
        int expectedMax,
        String expectedResult
    ) {
        CompetitionScore competition = new CompetitionScore();
        String[] tokens = inputScore.split("\\|");

        if ("INVALID".equals(expectedResult)) {
            assertThrows(IllegalArgumentException.class, () -> {
                int[] scores = new int[tokens.length];

                for (int i = 0; i < tokens.length; i++) {
                    if ("null".equals(tokens[i])) {
                        throw new IllegalArgumentException();
                    }
                    scores[i] = Integer.parseInt(tokens[i]);
                }

                competition.findMaxScore(scores);
            });
        } else {
            int[] scores = new int[tokens.length];

            for (int i = 0; i < tokens.length; i++) {
                scores[i] = Integer.parseInt(tokens[i]);
            }

            assertEquals(expectedMax, competition.findMaxScore(scores));
        }
    }
}
