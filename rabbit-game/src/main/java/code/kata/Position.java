package code.kata;

import code.kata.exception.PositionException;

import java.util.Random;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moveX(int x) {
        validRange(this.x + x);
        this.x += x;
    }

    public void moveY(int y) {
        validRange(this.y + y);
        this.y += y;
    }

    public boolean equals(Position position) {
        return this.x == position.getX() && this.y == position.getY();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static Position random() {
        return new Position(
                new Random().nextInt(49),
                new Random().nextInt(49));
    }

    private void validRange(int index) {
        if (!(0 <= index && index <= 49)) {
            throw new PositionException("좌표 범위 초과");
        }
    }
}
