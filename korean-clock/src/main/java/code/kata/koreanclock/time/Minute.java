package code.kata.koreanclock.time;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Minute {
    ZERO(0, List.of()),
    ONE(1, List.of(Point.of(4, 1))),
    TWO(2, List.of(Point.of(4, 2))),
    THREE(3, List.of(Point.of(4, 3))),
    FOUR(4, List.of(Point.of(4, 4))),
    FIVE(5, List.of(Point.of(5, 1))),
    SIX(6, List.of(Point.of(4, 5))),
    SEVEN(7, List.of(Point.of(5, 2))),
    EIGHT(8, List.of(Point.of(5, 3))),
    NINE(9, List.of(Point.of(5, 4))),

    TEN(10, List.of(Point.of(3, 5))),
    TWENTY(20, List.of(Point.of(3, 1), Point.of(3, 5))),
    THIRTY(30, List.of(Point.of(3, 2), Point.of(3, 5))),
    FORTY(40, List.of(Point.of(3, 3), Point.of(3, 5))),
    FIFTY(50, List.of(Point.of(3, 4), Point.of(3, 5)));

    private int minute;
    private List<Point> index;

    Minute(int minute, List<Point> index) {
        this.minute = minute;
        this.index = index;
    }

    public static List<Point> findMinute(int minute) {
        int tens = (minute / 10) * 10;
        int units = minute % 10;

        List<Point> tenList = Arrays.stream(Minute.values())
                .filter(ten -> ten.minute == tens)
                .findFirst()
                .orElseThrow()
                .index;

        List<Point> unitList = Arrays.stream(Minute.values())
                .filter(unit -> unit.minute == units)
                .findFirst()
                .orElseThrow()
                .index;

        List<Point> find = Stream.concat(tenList.stream(), unitList.stream())
                .collect(Collectors.toList());

        if (tens + units > 0) {
            find.add(Point.of(5, 5));
        }

        return find;
    }
}
