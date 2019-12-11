package kafkaDemoOne;

import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

public class RunProducer {
    public static void main(String[] args) {
        System.out.println("Run Producer main function");
        RunProducer rp = new RunProducer();
        rp.runProducer();
    }

    public void runProducer() {
        Producer<Long, String> producer = ProducerDemoOne.createProducer();
        for (int index = 0; index < IKafkaConstants.MESSAGE_COUNT; index++) {
            String message = "This is record " + index;
            ProducerRecord<Long, String> record = new ProducerRecord<Long, String>(IKafkaConstants.TOPIC_NAME, message);
            System.out.println("message:" + message);
            try {
                RecordMetadata metadata = producer.send(record).get();
                System.out.println("Record sent with key " + index + " to partition " + metadata.partition()
                        + " with offset " + metadata.offset());
            }
            catch (ExecutionException e) {
                System.out.println("Error in sending record");
                System.out.println(e);
            }
            catch (InterruptedException e) {
                System.out.println("Error in sending record");
                System.out.println(e);
            }
        }
    }

}
