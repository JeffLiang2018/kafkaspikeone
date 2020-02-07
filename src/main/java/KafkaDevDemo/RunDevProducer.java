package KafkaDevDemo;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.io.*;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

        public class RunDevProducer {
            public static void main(String[] args) {
                Producer<String, String> producer = DevProducer.createProducer();
                File folder = new File("/Users/j0l065j/Documents/temp/EA_solrDocs");
                String[] filenames = folder.list();
                for (int i = 0; i < filenames.length; i++) {
                    if (filenames[i].endsWith(".xml")) {
                        continue;
                    }
                    try {
                        BufferedReader reader = new BufferedReader(new FileReader(folder + File.separator + filenames[i]));
                        StringBuilder sb = new StringBuilder();
                        String line = reader.readLine();
                        while (line != null) {
                            sb.append(line);
                            line = reader.readLine();
                        }
                        String message = sb.toString();
                        ProducerRecord<String, String> record = new ProducerRecord<String, String>(IKafkaDevConstants.TOPIC_NAME, message);
                        RecordMetadata metadata = producer.send(record).get();
                        System.out.println(i + ": " + message);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                }
    }
}
