package code.kata.koreanclock;

import code.kata.koreanclock.time.Point;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class KoreaClock extends Thread {

    private final Korea korea;

    public KoreaClock(){
        korea = new Korea();
    }

    @Override
    public void start() {
        new Timer().scheduleAtFixedRate(new ScheduleTask(() -> {
            LocalTime localTime = LocalTime.now();
            korea.processing(localTime.getHour() % 12, localTime.getMinute());
            korea.print();
        }), new Date(), 1_000);
    }

    public List<Point> findPointList() {
        return korea.pointList;
    }

    private static class ScheduleTask extends TimerTask {

        private final Runnable runnable;

        public ScheduleTask(Runnable runnable) {
            this.runnable = runnable;
        }

        @Override
        public void run() {
            runnable.run();
        }

    }

}
