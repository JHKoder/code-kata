package code.kata.domain;

import code.kata.rockPaperScissors.Hand;

import java.util.Random;

public class Computer implements Player {
    private Hand hand;

    @Override
    public Hand getHand() {
        return hand;
    }

    @Override
    public void updateHand(Hand hand) {
        this.hand = hand;
    }

    public String getHandString() {
        return hand.toString();
    }

    public int randomInt(){
        return new Random().nextInt(3)+1;
    }
}
