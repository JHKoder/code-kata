package code.kata.koreanclock;

import java.util.List;
import java.util.Map;

public class ParenthesisCombination {

    public String parentheses(String str) {
        return "[" + str.charAt(1) + "]";
    }

    public String[][] process(Map<String, List<Integer>> map, String[][] arr, String time) {
        List<Integer> list = map.get(time);

        return process(list, arr);
    }

    public String[][] process(List<Integer> list, String[][] arr) {
        for (int i = 0; i < list.size(); i += 2) {
            arr[list.get(i)][list.get(i + 1)] = parentheses(arr[list.get(i)][list.get(i + 1)]);
        }
        return arr;
    }

}
