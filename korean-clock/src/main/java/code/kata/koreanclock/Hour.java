package code.kata.koreanclock;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hour {

    private String hour;
    private Map<String, List<Integer>> hourMap = new HashMap<>();
    private String[][] arr;

    public Hour(String[][] arr, String hour) {
        this.arr = arr.clone();
        this.hour = hour;
        hourMap.put("01", List.of(0, 0));
        hourMap.put("02", List.of(0, 1));
        hourMap.put("03", List.of(0, 2));
        hourMap.put("04", List.of(0, 3));
        hourMap.put("05", List.of(0, 4, 0, 5));
        hourMap.put("06", List.of(1, 0, 1, 1));
        hourMap.put("07", List.of(1, 2, 1, 3));
        hourMap.put("08", List.of(1, 4, 1, 5));
        hourMap.put("09", List.of(2, 0, 2, 1));
        hourMap.put("10", List.of(2, 2));
        hourMap.put("11", List.of(2, 2, 2, 3));
        hourMap.put("12", List.of(2, 2, 2, 4));
        hourMap.put("00", List.of(2, 2, 2, 4));
    }

    public String[][] processing() {
        List<Integer> xyList = hourMap.get(hour);

        for (int i = 0; i < xyList.size(); i += 2) {
            arr[xyList.get(i)][xyList.get(i + 1)] = parentheses(arr[xyList.get(i)][xyList.get(i + 1)]);
        }
        arr[2][5] = parentheses(arr[2][5]);
        return arr;
    }

    public String parentheses(String str) {
        return "[" + str + "]";
    }

}