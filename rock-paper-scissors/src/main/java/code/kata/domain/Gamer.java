package code.kata.domain;

public class Gamer {
    private final Hand hand;

    public Gamer(Hand hand) {
        this.hand = hand;
    }

    public Hand getHand() {
        return hand;
    }

    public Result match(Gamer gamer){
        return hand.fight(gamer.getHand());
    }
}
