package code.kata.exception;

public class RockPaperScissorsInputException extends RuntimeException{
    public RockPaperScissorsInputException() {
        super("가위 바위 보 게임 입력오류");
    }
}
