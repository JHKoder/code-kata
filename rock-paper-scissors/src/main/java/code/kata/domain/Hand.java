package code.kata.domain;

import java.util.Arrays;

public enum Hand {
    SCISSORS(1),
    ROCK(2),
    PAPER(3);

    private final int index;

    Hand(int index) {
        this.index = index;
    }

    public static Hand valueOf(int index) {
        return Arrays.stream(values()).filter(hand -> hand.index == index).findFirst()
                .orElseThrow();
    }

    public Result fight(Hand hand) {
        if ((this.index % 3) + 1 == hand.index) {
            return Result.LOSE;
        } else if (this.index == hand.index) {
            return Result.DRAW;
        }
        return Result.WIN;
    }
}
