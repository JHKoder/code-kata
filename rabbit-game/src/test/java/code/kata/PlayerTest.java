package code.kata;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("플레이어는")
public class PlayerTest {

    @Test
    @DisplayName("왼쪽으로 움직일 수 있다.")
    void playerMoveToLeft(){
        Player player = new Player(Position.random());
    }

    @Test
    @DisplayName("오른쪽으로 움직일 수 있다.")
    void playerMoveToRight(){

    }

    @Test
    @DisplayName("위쪽으로 움직일 수 있다.")
    void playerMoveToTop(){

    }

    @Test
    @DisplayName("아래쪽으로 움직일 수 있다.")
    void playerMoveToDown(){

    }

    @Test
    @DisplayName("같은 위치일때 토끼를 잡을 수 있다.")
    void catchRabbit(){

    }
}
