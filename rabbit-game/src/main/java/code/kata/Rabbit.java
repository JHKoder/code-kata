package code.kata;

import code.kata.exception.PositionException;

import java.util.Random;

public class Rabbit {

    private final Position position;

    public Position getPosition() {
        return position;
    }

    public Rabbit(Position position) {
        this.position =position;
    }

    public boolean equalsPosition(Position position) {
        return this.position.equals(position);
    }

    public void moveRandom() {
        try {
            position.moveX(randInt(5));
            position.moveY(randInt(5));
        }catch (PositionException e){
            moveRandom();
        }
    }
    private int randInt(int range){
        int num = new Random().nextInt(range);
        if(new Random().nextBoolean()){
            return num*-1;
        }
        return num;
    }
}
