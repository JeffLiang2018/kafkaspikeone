package KafkaPerformance;

import kafkaDemoOne.RunConsumer;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class RunPerfConsumer {
    public static void main(String[] args) {
        System.out.println("Start Consumer to push xml data to Solr");
        LocalDateTime startTime = LocalDateTime.now();
        RunConsumer consumer = new RunConsumer();
        consumer.runConsumer();
        LocalDateTime endTime = LocalDateTime.now();
        long hours = ChronoUnit.HOURS.between(startTime, endTime);
        long minutes = ChronoUnit.MINUTES.between(startTime, endTime);
        long seconds = ChronoUnit.SECONDS.between(startTime, endTime);
        System.out.println("Producer takes " + hours + ":" + minutes + ":" + seconds + " to complete");
    }
}
