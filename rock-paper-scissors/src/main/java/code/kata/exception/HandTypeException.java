package code.kata.exception;

public class HandTypeException extends RuntimeException {
    public HandTypeException() {
        super("손 동작을 알 수 없습니다.");
    }
}
