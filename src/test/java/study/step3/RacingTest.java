package study.step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step3.domain.Car;
import step3.domain.Racing;
import step3.domain.RacingRule;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class RacingTest {

    private RacingRule racingRule;

    @BeforeEach
    void setUp() {
        racingRule = new RacingRule();
    }


    @ParameterizedTest
    @CsvSource(value = {"3,7", "4,6"}, delimiter = ',')

    void 입력값_자동차_객체_생성(int input, int attempt) {

        for (int i = 0; i < 5; i++) {
            Racing racing = new Racing(input,attempt);
            assertEquals(racing.getCars().getCars().size(), input);
        }
    }

    @ParameterizedTest
    @ValueSource(ints = 10)
    void 난수_생성_테스트(int number) {

        for (int i = 0; i < number; i++) {
            int random = racingRule.makeRandomNumber();
            System.out.println("Random Number " + i + ": " + random);
            assertThat(random).isBetween(0, 10);
        }
    }


}
