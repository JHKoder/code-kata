package code.kata.koreanclock;

import java.time.LocalTime;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class KoreaClock extends Thread {

    @Override
    public void start() {
        new Timer().scheduleAtFixedRate(new ScheduleTask(() -> {
            LocalTime localTime = LocalTime.now();

            Korea korea = new Korea();
            korea.processing(localTime.getHour() % 12, localTime.getMinute());
            korea.print();
        }), new Date(), 1_000);
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
