package code.kata;


import code.kata.console.ConsoleInputAdapter;
import code.kata.console.ConsoleOutputAdapter;
import code.kata.domain.Computer;
import code.kata.domain.User;
import code.kata.rockPaperScissors.Factory;
import code.kata.rockPaperScissors.Hand;

public class RockPaperScissors {
    private final User user;
    private final Computer computer;
    private final Factory factory;

    public RockPaperScissors(User user, Computer computer) {
        this.user = user;
        this.computer = computer;
        this.factory = new Factory();
    }

    public void play() {
        ConsoleInputAdapter input = new ConsoleInputAdapter();
        ConsoleOutputAdapter output = new ConsoleOutputAdapter();

        output.userInputMessage();
        factory.moveHand(user , userCommand(input));
        factory.moveHand(computer,  factory.apply(computer.randomInt()));

        output.resultMessage(
                user.getHandString(),
                computer.getHandString(),
                user.getHandFightString(computer.getHand())
        );

        input.close();
    }

    private Hand userCommand(ConsoleInputAdapter inputAdapter){
        return factory.apply(inputAdapter.input());
    }
}
