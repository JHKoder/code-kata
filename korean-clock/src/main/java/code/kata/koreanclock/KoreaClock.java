package code.kata.koreanclock;

import code.kata.koreanclock.time.Point;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;
import org.springframework.stereotype.Component;

@Component
public class KoreaClock extends Thread {

    private final Map<Country, Korea> countryThreadMap = new HashMap<>();

    public KoreaClock() {
        start();
    }

    public List<Point> findPointList(Country code) {
        return countryThreadMap.get(code).findPointList();
    }

    public void start() {
        for (Country cou : Country.values()) {
            countryThreadMap.put(cou, new Korea());
        }
        new Timer().scheduleAtFixedRate(new ScheduleTask(() -> {
            for (Country cou : Country.values()) {
                CalendarThread(cou, countryThreadMap.get(cou));
            }
        }), new Date(), 1_000);
    }

    private void CalendarThread(Country cou, Korea korea) {
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone(cou.getCode()));
        korea.processing(cal.get(Calendar.HOUR), cal.get(Calendar.MINUTE));
        korea.print(cou);
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
