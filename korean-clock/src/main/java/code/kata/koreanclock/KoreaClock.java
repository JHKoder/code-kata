package code.kata.koreanclock;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class KoreaClock extends Thread {

    public KoreaClock() {
    }

    @Override
    public void start() {
        new Timer().scheduleAtFixedRate(new ScheduleTask(() -> {
            LocalTime localTime = LocalTime.now();

            String hour = localTime.format(DateTimeFormatter.ofPattern("hh"));
            String minute = localTime.format(DateTimeFormatter.ofPattern("mm"));

            Korea korea= new Korea();
            korea.gettingItRight(hour,minute,localTime.getHour());
            korea.print();
        }), new Date(), 5_000);
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
