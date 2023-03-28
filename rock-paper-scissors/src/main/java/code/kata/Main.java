package code.kata;

import code.kata.domain.Computer;
import code.kata.domain.User;

public class Main {

    public static void main(String[] args) {
        User user = new User();
        Computer computer = new Computer();
        RockPaperScissors game = new RockPaperScissors(user,computer);
        game.play();
    }
}
