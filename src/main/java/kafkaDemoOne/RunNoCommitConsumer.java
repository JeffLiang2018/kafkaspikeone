package kafkaDemoOne;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.common.TopicPartition;

import java.time.Duration;

public class RunNoCommitConsumer {
    public static void main(String[] args) {
        Consumer<Long, String> consumer = ConsumerDemoOne.createConsumer();
        int noMessageFound = 0;
        while (true) {
            ConsumerRecords<Long, String> consumerRecords = consumer.poll(1000);
            // 1000 is the time in milliseconds consumer will wait if no record is found at broker.
            if (consumerRecords.count() == 0) {
                noMessageFound++;
                if (noMessageFound > IKafkaConstants.MAX_NO_MESSAGE_FOUND_COUNT)
                    // If no message found count is reached to threshold exit loop.
                    break;
                else
                    continue;
            }
            //print each record.
//            consumerRecords.forEach(record -> {
//                System.out.println("Record Key: " + record.key());
//                System.out.println("Record value " + record.value());
////                System.out.println("Record partition " + record.partition());
////                System.out.println("Record offset " + record.offset());
//                int partition = record.partition();
//                System.out.println("Record partition " + partition);
//                long offset = record.offset();
//                System.out.println("Record offset " + offset);
//
//                consumer.seek(new TopicPartition(IKafkaConstants.TOPIC_NAME, partition), offset);
//            });
            int partition = -1;
            long offset = -1;
            for (ConsumerRecord<Long, String> record : consumerRecords) {
                partition = (partition == -1) ? record.partition() : partition;
                offset = (offset == -1) ? record.offset() : offset;
                System.out.println("1st Time Loop: " + record.value());
            }
            // save the record into Solr
            // no we think, the update if fail
            if (true) {   // assume the update fail
                consumer.seek(new TopicPartition(IKafkaConstants.TOPIC_NAME, partition), offset);
                ConsumerRecords<Long, String> consumerRecords2 = consumer.poll(Duration.ofSeconds(1));
                if (consumerRecords2.count() == 0) {
                    continue;
                }
                for (ConsumerRecord<Long, String> record2 : consumerRecords2) {
                    System.out.println("2nd Time Loop: " + record2.value());
                }
            }
            // commits the offset of record to broker.
            consumer.commitAsync();
        }
        consumer.close();
    }
}
