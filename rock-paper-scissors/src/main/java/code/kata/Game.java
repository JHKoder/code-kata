package code.kata;


import code.kata.console.ConsoleInput;
import code.kata.console.ConsoleOutput;
import code.kata.domain.Gamer;
import code.kata.domain.Hand;

import java.util.Random;

public class Game {

    public void play() {
        ConsoleOutput output = new ConsoleOutput();

        output.userInputMessage();

        Gamer user = new Gamer(userInputCommand());
        Gamer computer = new Gamer(Hand.valueOf(randomInt()));

        output.resultMessage(user, computer);
    }

    public int randomInt() {
        return new Random().nextInt(3) + 1;
    }

    private Hand userInputCommand() {
        try (ConsoleInput inputAdapter = new ConsoleInput()) {
            return Hand.valueOf(inputAdapter.input());
        }
    }
}
