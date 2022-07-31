package code.kata.koreanclock.time;


import java.util.Arrays;
import java.util.List;

public enum HourEnum {
    HOUR_ZERO(0, List.of(Point.of(2, 2), Point.of(2, 4), Point.of(2, 5))),
    HOUR_ONE(1, List.of(Point.of(0, 0), Point.of(2, 5))),
    HOUR_TWO(2, List.of(Point.of(0, 1), Point.of(2, 5))),
    HOUR_THREE(3, List.of(Point.of(0, 2), Point.of(2, 5))),
    HOUR_FOUR(4, List.of(Point.of(0, 3), Point.of(2, 5))),
    HOUR_FIVE(5, List.of(Point.of(0, 4), Point.of(0, 5), Point.of(2, 5))),
    HOUR_SIX(6, List.of(Point.of(1, 0), Point.of(1, 1), Point.of(2, 5))),
    HOUR_SEVEN(7, List.of(Point.of(1, 2), Point.of(1, 3), Point.of(2, 5))),
    HOUR_EIGHT(8, List.of(Point.of(1, 4), Point.of(1, 5), Point.of(2, 5))),
    HOUR_NINE(9, List.of(Point.of(2, 0), Point.of(2, 1), Point.of(2, 5))),
    HOUR_TEN(10, List.of(Point.of(2, 2), Point.of(2, 5))),
    HOUR_ELEVEN(11, List.of(Point.of(2, 2), Point.of(2, 3), Point.of(2, 5))),
    HOUR_TWELVE(12, List.of(Point.of(2, 2), Point.of(2, 4), Point.of(2, 5)));

    private int hours;
    private List<Point> index;

    HourEnum(int hours, List<Point> index) {
        this.hours = hours;
        this.index = index;
    }

    public static List<Point> findHour(int hour) {
        return Arrays.stream(values())
                .filter(h -> h.hours == hour)
                .findFirst()
                .orElseThrow()
                .index;
    }
}
