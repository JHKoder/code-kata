package code.kata.rockPaperScissors;

import code.kata.exception.HandTypeException;

public class Rock implements Hand {
    private final int ID = 2;

    @Override
    public Result fight(Hand hand) {
        if (hand instanceof Scissors) {
            return Result.WIN;
        }
        if (hand instanceof Paper){
            return Result.LOSE;
        }
        if (hand instanceof Rock){
            return Result.DRAW;
        }
        throw new HandTypeException();
    }

    @Override
    public String toString() {
        return "바위";
    }
}