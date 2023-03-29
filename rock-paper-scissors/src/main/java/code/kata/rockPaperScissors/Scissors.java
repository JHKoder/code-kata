package code.kata.rockPaperScissors;

import code.kata.exception.HandTypeException;

public class Scissors implements Hand {
    private static final int ID = 1;

    public static boolean equalsId(int number) {
        return ID == number;
    }

    @Override
    public Result fight(Hand hand) {
        if (hand instanceof Paper) {
            return Result.WIN;
        }
        if (hand instanceof Rock){
            return Result.LOSE;
        }
        if (hand instanceof Scissors){
            return Result.DRAW;
        }
        throw new HandTypeException();
    }

    @Override
    public String toString() {
        return "가위";
    }
}
