package code.kata.koreanclock;

public class Meridian extends ParenthesisCombination implements ParenthesisCombinationInterface {

    private final int hour;
    private String[][] arr;

    public Meridian(String[][] arr, int hour) {
        this.arr = arr;
        this.hour = hour;
    }

    public String[][] processing() {
        if (hour == 0) {
            arr[3][0] = parentheses(arr[3][0]);
            arr[4][0] = parentheses(arr[4][0]);
            return arr;
        }
        if (hour == 12) {
            arr[4][0] = parentheses(arr[4][0]);
            arr[5][0] = parentheses(arr[5][0]);
            return arr;
        }
        return arr;
    }


}
