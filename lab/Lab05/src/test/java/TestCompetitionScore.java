import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import com.sqa.lab.CompetitionScore;

public class TestCompetitionScore {

    @ParameterizedTest
    @DisplayName("Test findMaxScore(int, int, int)")
    @CsvFileSource(
            files = "src/test/resources/CompetitionScore.csv",
            numLinesToSkip = 1,
            nullValues = "null"
    )
    void testFindMaxScore3(
            int score1,
            int score2,
            int score3,
            int expected,
            String expectedResult
    ) {

        CompetitionScore competition = new CompetitionScore();

        if ("INVALID".equals(expectedResult)) {
            assertThrows(
                    IllegalArgumentException.class,
                    () -> competition.findMaxScore(score1, score2, score3)
            );
        } else {
            assertEquals(
                    expected,
                    competition.findMaxScore(score1, score2, score3)
            );
        }
    }

    @ParameterizedTest
    @DisplayName("Test findMaxScore(int[])")
    @CsvFileSource(
            files = "src/test/resources/CompetitionScoreArray.csv",
            numLinesToSkip = 1
    )
    void testFindMaxScoreArray(
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
                    if ("null".equalsIgnoreCase(tokens[i])) {
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

            assertEquals(
                    expectedMax,
                    competition.findMaxScore(scores)
            );
        }
    }
}
