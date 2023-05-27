package code.kata;

import code.kata.console.ConsoleOutput;
import code.kata.console.Input;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Player player = new Player(Position.random());
        Rabbit rabbit = new Rabbit(Position.random());
        Input input = new Input();
        ConsoleOutput output = new ConsoleOutput();

        while(true){
            output.livePosition(player,rabbit);
            rabbit.moveRandom();
            output.playerCommand();
            int[] nums = Arrays.stream(input.command())
                    .mapToInt(Integer::parseInt).toArray();
            player.move(nums[0],nums[1]);
            if(player.catchRabbit(rabbit)){
                output.caughtTheRabbit();
                break;
            }
        }
    }
}
