package code.kata.domain;


import code.kata.rockPaperScissors.Hand;

public interface Player {
    Hand getHand();
    void updateHand(Hand hand);
}
