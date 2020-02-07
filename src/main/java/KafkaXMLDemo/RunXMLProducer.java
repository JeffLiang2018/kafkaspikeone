package KafkaXMLDemo;

import kafkaDemoOne.IKafkaConstants;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.concurrent.ExecutionException;

public class RunXMLProducer {
    public static void main(String[] args) {
        File xmlFile = new File("/Users/j0l065j/Documents/temp/solrDocs/00085369992051.xml");
        try {
            Reader fileReader = new FileReader(xmlFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuilder sb = new StringBuilder();
            String line = bufferedReader.readLine();
            while (line != null) {
                sb.append(line).append("");
                line = bufferedReader.readLine();
            }
            String message = sb.toString();
            ProducerRecord<Long, String> record = new ProducerRecord<Long, String>(IKafkaConstants.TOPIC_NAME, message);
            System.out.println("message:" + message);
            Producer<Long, String> producer = XMLProducer.createProducer();
            try {
                RecordMetadata metadata = producer.send(record).get();
            } catch (ExecutionException e) {
                System.out.println("Error in sending record");
                System.out.println(e);
            } catch (InterruptedException e) {
                System.out.println("Error in sending record");
                System.out.println(e);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Finish sending messages to Kafka");
    }
}
