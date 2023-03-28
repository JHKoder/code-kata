package code.kata.rockPaperScissors;

import code.kata.domain.Player;

public class Factory {
    public Hand apply(int number){
        if(number == 1) return new Scissors();
        if(number == 2) return new Rock();
        if(number == 3) return new Paper();
        throw new IllegalArgumentException("가위 바위 보 범위를 벗어 났습니다.");
    }

    public void moveHand(Player user, Hand userCommand) {
        user.updateHand(userCommand);
    }
}
