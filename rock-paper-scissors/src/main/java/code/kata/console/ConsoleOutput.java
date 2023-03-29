package code.kata.console;

import code.kata.domain.Gamer;

public class ConsoleOutput {
    public void userInputMessage(){
        println("가위[1] ,바위[2] ,보[3] 중에서 숫자를 입력해주세요.");
    }

    public void resultMessage(Gamer user, Gamer computer) {
        printf(" 유저  : [%s] %n 컴퓨터 : [%s] %n 유저가 [%s] 했습니다.", user.getHand(), computer.getHand(),user.match(computer));
    }

    private void printf(String message, Object ... args){
        System.out.printf(message,args);
    }

    private void println(String message){
        System.out.println(message);
    }
}
