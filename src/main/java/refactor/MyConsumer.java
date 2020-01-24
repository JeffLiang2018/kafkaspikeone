package refactor;

public class MyConsumer {

    public static MyConsumer createConsumer() {
        return new MyConsumer();
    }
    MyConsumerRecords records = new MyConsumerRecords();

    public MyConsumerRecords poll() {
        return records;
    }

    public void setMyConsumerRecords(MyConsumerRecords records) {
        this.records = records;
    }
}
