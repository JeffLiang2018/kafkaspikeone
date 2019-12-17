package KafkaPerformance;

import KafkaXMLDemo.XMLProducer;
import kafkaDemoOne.IKafkaConstants;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.ExecutionException;

public class RunPerfProducer {
    public static void main(String[] args) {
        System.out.println("Start Procuder to push xml data to Kafka");
        LocalDateTime startTime = LocalDateTime.now();
        try {
            File folder = new File("/Users/j0l065j/Downloads/solrDocs");
            String[] files = folder.list();
            Producer<Long, String> producer = XMLProducer.createProducer();
            for (int i = 0; i < files.length; i++) {
                if (!files[i].endsWith(".xml")) {
                    continue;
                } else {
                    Reader fileReader = new FileReader(folder + File.separator + files[i]);
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    StringBuilder sb = new StringBuilder();
                    String line = bufferedReader.readLine();
                    while (line != null) {
                        sb.append(line).append("");
                        line = bufferedReader.readLine();
                    }
                    String message = sb.toString();
                    ProducerRecord<Long, String> record = new ProducerRecord<Long, String>(IKafkaConstants.TOPIC_NAME, message);
                    System.out.println("sent message:" + message);
                    try {
                        RecordMetadata metadata = producer.send(record).get();
                    }
                    catch (ExecutionException e) {
                        System.out.println(e);
                    }
                    catch (InterruptedException e) {
                        System.out.println(e);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Finish sending messages to Kafka");
        LocalDateTime endTime = LocalDateTime.now();
        long hours = ChronoUnit.HOURS.between(startTime, endTime);
        long minutes = ChronoUnit.MINUTES.between(startTime, endTime);
        long seconds = ChronoUnit.SECONDS.between(startTime, endTime);
        System.out.println("Producer takes " + hours + ":" + minutes + ":" + seconds + " to complete");
    }
}
