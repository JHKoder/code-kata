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
        return Arrays.stream(values())
                .filter(hand -> hand.index == index).findFirst()
                .orElseThrow();
    }

    public Result fight(Hand hand) {
        if (isLose(hand)) {
            return Result.LOSE;
        }else if (isDraw(hand)) {
            return Result.DRAW;
        } return Result.WIN;
    }

    private boolean isLose(Hand hand){
        return (this.index % 3) + 1 == hand.index;
    }

    private boolean isDraw(Hand hand){
        return this.index == hand.index;
    }
}
