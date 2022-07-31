package code.kata.koreanclock;

import code.kata.koreanclock.time.HourEnum;
import code.kata.koreanclock.time.MeridianEnum;
import code.kata.koreanclock.time.MinuteEnum;
import code.kata.koreanclock.time.Point;
import java.util.ArrayList;
import java.util.List;

public class Korea {

    private String[][] arr = {
            {"한", "두", "세", "네", "다", "섯"},
            {"여", "섯", "일", "곱", "여", "덟"},
            {"아", "홉", "열", "한", "두", "시"},
            {"자", "이", "삼", "사", "오", "십"},
            {"정", "일", "이", "삼", "사", "육"},
            {"오", "오", "칠", "팔", "구", "분"}
    };

    private List<Point> pointList = new ArrayList<>();

    public void processing(int hour, int minute) {

        if (MeridianEnum.isMeridian(hour, minute)) {
            pointList.addAll(MeridianEnum.findMeridian(hour, minute));
            return;
        }

        pointList.addAll(HourEnum.findHour(hour));
        pointList.addAll(MinuteEnum.findMinute(minute));
    }

    public void print() {
        System.out.print("\n".repeat(5));

        for (int x = 0; x < arr.length; x++) {
            for (int y = 0; y < arr[x].length; y++) {

                final int finalX = x;
                final int finalY = y;

                boolean isPoint = pointList.stream()
                        .anyMatch(in -> in.isEquals(finalX, finalY));

                if (isPoint) {
                    System.out.print(parentheses(arr[x][y]) + " ");
                } else {
                    System.out.print(arr[x][y] + " ");
                }
            }
            System.out.println("");
        }

    }

    public String parentheses(String str) {
        return String.format("[%s]", str);
    }

}
