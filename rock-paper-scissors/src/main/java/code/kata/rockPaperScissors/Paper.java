package code.kata.rockPaperScissors;


import code.kata.exception.HandTypeException;

public class Paper implements Hand {
    private static final int ID = 3;

    public static boolean equalsId(int number) {
        return ID == number;
    }

    @Override
    public Result fight(Hand hand) {
        if (hand instanceof Rock) {
            return Result.WIN;
        }
        if (hand instanceof Scissors){
            return Result.LOSE;
        }
        if (hand instanceof Paper){
            return Result.DRAW;
        }
        throw new HandTypeException();
    }

    @Override
    public String toString() {
        return "보";
    }
}
