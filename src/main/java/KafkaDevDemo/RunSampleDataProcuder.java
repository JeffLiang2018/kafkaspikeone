package KafkaDevDemo;

import KafkaXMLDemo.XMLProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.concurrent.ExecutionException;

import static KafkaDevDemo.DevProducer.createProducer;

public class RunSampleDataProcuder {
    public static void main(String[] args) {
        File xmlFile = new File("/Users/j0l065j/Documents/temp/EA_solrDocs/DELETE_00008616260245.xml");
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
            ProducerRecord<String, String> record = new ProducerRecord<String, String>(IKafkaDevConstants.TOPIC_NAME, message);
            Producer<String, String> producer = DevProducer.createProducer();
            try {
                RecordMetadata metadata = producer.send(record).get();
                System.out.println("message sent:" + message);
            }
            catch (ExecutionException e) {
                System.out.println("Error in sending record");
                System.out.println(e);
            }
            catch (InterruptedException e) {
                System.out.println("Error in sending record");
                System.out.println(e);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Finish sending messages to Kafka");
    }
}
