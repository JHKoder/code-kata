package code.kata.koreanclock;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Minute {

    String minute;

    Map<String, List<Integer>> units = new HashMap<>();
    Map<String, List<Integer>> tens = new HashMap<>();

    String[][] arr;

    public Minute(String[][] arr, String minute) {
        this.minute = minute;
        this.arr = arr;

        units.put("0", List.of());
        units.put("1", List.of(4, 1));
        units.put("2", List.of(4, 2));
        units.put("3", List.of(4, 3));
        units.put("4", List.of(4, 4));
        units.put("5", List.of(5, 1));
        units.put("6", List.of(4, 5));
        units.put("7", List.of(5, 2));
        units.put("8", List.of(5, 3));
        units.put("9", List.of(5, 4));

        tens.put("0", List.of());
        tens.put("1", List.of(3, 5));
        tens.put("2", List.of(3, 1, 3, 5));
        tens.put("3", List.of(3, 2, 3, 5));
        tens.put("4", List.of(3, 3, 3, 5));
        tens.put("5", List.of(3, 4, 3, 5));

    }

    public String[][] processing() {
        String left = minute.charAt(0) + "";
        String right = minute.charAt(1) + "";

        List<Integer> tenList = tens.get(left);
        List<Integer> unitList = units.get(right);

        for (int i = 0; i < tenList.size(); i += 2) {
            arr[tenList.get(i)][tenList.get(i + 1)] = parentheses(arr[tenList.get(i)][tenList.get(i + 1)]);
        }
        for (int i = 0; i < unitList.size(); i += 2) {
            arr[unitList.get(i)][unitList.get(i + 1)] = parentheses(arr[unitList.get(i)][unitList.get(i + 1)]);
        }
        if (!(left.equals("0") && right.equals("0"))) {
            arr[5][5] = parentheses(arr[5][5]);
        }
        return arr;
    }

    public String parentheses(String str) {
        return "[" + str + "]";
    }
}
