package refactor;

import org.junit.jupiter.api.Test;

public class ConsumerTest {

    @Test
    public void testXXX() {
        RunConsumerKafkaData runConsumerKafkaData = new RunConsumerKafkaData();
        runConsumerKafkaData.indexerRepository = new IndexerRepository();
        runConsumerKafkaData.myconsumer = new MyConsumer();

    }
}
