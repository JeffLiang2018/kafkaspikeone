package time;



import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


public class TimeTest {

    @Test
    public void testTimeDifference() {
        LocalDateTime startTime = LocalDateTime.now();
        try {
            Thread.sleep(5000);
        } catch (Exception e) {

        }
        LocalDateTime endTime = LocalDateTime.now();
        long hours = ChronoUnit.HOURS.between(startTime, endTime);
        long minutes = ChronoUnit.MINUTES.between(startTime, endTime);
        long seconds = ChronoUnit.SECONDS.between(startTime, endTime);
        System.out.println("The program takes " + hours + ":" + minutes + ":" + seconds);
    }
}
