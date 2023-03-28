package code.kata.koreanclock.time;

import java.util.Arrays;
import java.util.List;

public enum Meridian {
    MIDNIGHT(0,0, List.of(Point.of(3, 0), Point.of(4, 0))),
    NOON(12,0, List.of(Point.of(5, 0), Point.of(4, 0)));

    private int hour;
    private int minute;
    private List<Point> index;

    Meridian(int hour,int minute, List<Point> index) {
        this.hour=hour;
        this.minute=minute;
        this.index=index;
    }

    public static boolean isMeridian(int hour,int minute){
        return Arrays.stream(values())
                .anyMatch( time -> time.hour == hour && time.minute ==minute);
    }
    public static List<Point>  findMeridian(int hour,int minute){
        return Arrays.stream(values())
                .filter(time -> time.hour == hour && time.minute == minute)
                .findFirst()
                .orElseThrow()
                .index;
    }
}
