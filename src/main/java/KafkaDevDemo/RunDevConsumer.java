package KafkaDevDemo;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;

import java.time.Duration;

public class RunDevConsumer {

    public static void main(String[] args) {
        int noMessageFound = 0;
        int messageIndex = 0;
        Consumer consumer = DevConsumer.createConsumer();

        while (true) {
            ConsumerRecords<String, String> consumerRecords = consumer.poll(Duration.ofMinutes(2));
            if (consumerRecords.count() == 0) {
                noMessageFound++;
                if (noMessageFound > 5) {
                    break;
                } else {
                    continue;
                }
            } else {
                for (ConsumerRecord<String, String> consumerRecord : consumerRecords) {
                    int partition = consumerRecord.partition();
                    long offset = consumerRecord.offset();
                    String value = consumerRecord.key();
                    String message = consumerRecord.value();
                    System.out.println("message: " + message);
                }
                consumer.commitAsync();
            }
        }
        consumer.close();
    }

}
