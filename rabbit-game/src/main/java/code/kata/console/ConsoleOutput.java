package code.kata.console;

import code.kata.Player;
import code.kata.Rabbit;

import static java.lang.System.out;

public class ConsoleOutput {
    public void playerCommand() {
        out.println("플레이어의 x,y 좌표를 입력해 주세요('공백구분')");
    }

    public void caughtTheRabbit() {
        out.println("플레이어가 토끼를 잡았습니다.");
    }

    public void livePosition(Player player, Rabbit rabbit) {
        out.println("플레이어 x:"+player.getPosition().getX() +" y:"+player.getPosition().getY());
        out.println("토끼 x:"+rabbit.getPosition().getX() +" y:"+rabbit.getPosition().getY());
        out.println();
    }
}
