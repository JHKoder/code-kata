package code.kata;

import code.kata.exception.PositionException;

public class Player {
    private final Position position;

    public Position getPosition() {
        return position;
    }

    public Player(Position position) {
        this.position =position;
    }

    public void move(int x,int y){
        validMove(x);
        validMove(y);
        position.moveX(x);
        position.moveY(y);
    }

    public boolean catchRabbit(Rabbit rabbit) {
        return rabbit.equalsPosition(position);
    }

    private void validMove(int index) {
        if(!(index <= 10)){
            throw new PositionException("최대 이동 범위 초과");
        }
    }
}
