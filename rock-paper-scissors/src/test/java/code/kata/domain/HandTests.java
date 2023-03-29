package code.kata.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Hand")
class HandTests {

    @ParameterizedTest
    @MethodSource("handProvider")
    @DisplayName("가위 바위 보 승부 검증")
    void validFight(Hand player, Hand target, Result result) {
        assertThat(player.fight(target)).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("handIndexProvider")
    @DisplayName("숫자 1 ~ 3 을 Hand 으로 바꿀수 있는지 검증")
    void validValueOf(int index, Hand hand) {
        assertThat(Hand.valueOf(index)).isEqualTo(hand);
    }

    private static Stream<Arguments> handProvider() {
        return Stream.of(
                Arguments.of(Hand.SCISSORS, Hand.ROCK, Result.LOSE),
                Arguments.of(Hand.ROCK, Hand.PAPER, Result.LOSE),
                Arguments.of(Hand.PAPER, Hand.SCISSORS, Result.LOSE),
                Arguments.of(Hand.SCISSORS, Hand.PAPER, Result.WIN),
                Arguments.of(Hand.PAPER, Hand.ROCK, Result.WIN),
                Arguments.of(Hand.ROCK, Hand.SCISSORS, Result.WIN)
        );
    }

    private static Stream<Arguments> handIndexProvider() {
        return Stream.of(
                Arguments.of(1, Hand.SCISSORS),
                Arguments.of(2, Hand.ROCK),
                Arguments.of(3, Hand.PAPER)
        );
    }
}