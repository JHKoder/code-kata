package code.kata.rockPaperScissors;

import code.kata.domain.Player;

public class Factory {
    public Hand apply(int number){
        if(Scissors.equalsId(number)) return new Scissors();
        if(Rock.equalsId(number)) return new Rock();
        if(Paper.equalsId(number)) return new Paper();
        throw new IllegalArgumentException("가위 바위 보 범위를 벗어 났습니다.");
    }

    public void moveHand(Player player, Hand hand) {
        player.updateHand(hand);
    }
}
