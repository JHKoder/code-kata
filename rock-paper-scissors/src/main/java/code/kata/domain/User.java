package code.kata.domain;


import code.kata.rockPaperScissors.Hand;

public class User implements Player {
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

    public String getHandFightString(Hand hand) {
        return this.hand.fight(hand).toString();
    }
}
