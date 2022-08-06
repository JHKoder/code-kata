package code.kata.koreanclock;

import code.kata.koreanclock.time.Hour;
import code.kata.koreanclock.time.Meridian;
import code.kata.koreanclock.time.Minute;
import code.kata.koreanclock.time.Point;
import java.util.ArrayList;
import java.util.List;


public class Korea {

    private static final String[][] arr = {
            {"한", "두", "세", "네", "다", "섯"},
            {"여", "섯", "일", "곱", "여", "덟"},
            {"아", "홉", "열", "한", "두", "시"},
            {"자", "이", "삼", "사", "오", "십"},
            {"정", "일", "이", "삼", "사", "육"},
            {"오", "오", "칠", "팔", "구", "분"}
    };

    private List<Point> pointList = new ArrayList<>();

    public void processing(int hour, int minute) {
        pointList = new ArrayList<>();

        if (Meridian.isMeridian(hour, minute)) {
            pointList.addAll(Meridian.findMeridian(hour, minute));
            return;
        }

        pointList.addAll(Hour.findHour(hour));
        pointList.addAll(Minute.findMinute(minute));
    }

    public List<Point> findPointList() {
        return pointList;
    }

    public void print(Country cou) {
        System.out.print("\n".repeat(2));

        System.out.println("나라 : "+ cou.getName());
        for (int x = 0; x < arr.length; x++) {
            for (int y = 0; y < arr[x].length; y++) {
                printValue(x, y);
            }
            System.out.println("");
        }

    }

    private void printValue(int x, int y) {
        boolean isMatch = pointList.stream()
                .anyMatch(in -> in.isEquals(x, y));

        if (isMatch) {
            System.out.print(parentheses(arr[x][y]));
        }
        if (!isMatch) {
            System.out.print(" " +arr[x][y] + " ");
        }
    }

    private String parentheses(String str) {
        return String.format("[%s]", str);
    }

}
