package code.kata.koreanclock;

import java.util.Objects;

public class Korea {

    private String[][] arr = {
            {"한", "두", "세", "네", "다", "섯"},
            {"여", "섯", "일", "곱", "여", "덟"},
            {"아", "홉", "열", "한", "두", "시"},
            {"자", "이", "삼", "사", "오", "십"},
            {"정", "징", "이", "삼", "사", "육"},
            {"오", "오", "칠", "팔", "구", "분"}
    };


    public void gettingItRight(String hour, String minute, int hours) {
        Meridian meridian = new Meridian(arr, hours);

        if (Objects.equals(hour, "00") && Objects.equals(minute, "00")) {
            arr = meridian.processing();
            return;
        }

        Hour hourObj = new Hour(arr, hour);
        arr = hourObj.processing();

        Minute minuteObj = new Minute(arr, minute);
        arr = minuteObj.processing();
    }

    public void print(){
        for(int i=0;i<5;i++){
            System.out.println("");
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
    }


}
