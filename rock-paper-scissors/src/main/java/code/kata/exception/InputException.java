package code.kata.exception;

public class InputException extends RuntimeException{
    public InputException() {
        super("가위 바위 보 게임 입력오류");
    }
}
