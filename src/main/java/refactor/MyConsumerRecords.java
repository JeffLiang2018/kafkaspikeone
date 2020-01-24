package refactor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class MyConsumerRecords{

    public List<MyConsumeRecord> recordList;

    public int count() {
        return 0;
    }

    public MyConsumerRecords() {
        this.recordList = new ArrayList<>();
        recordList.add(new MyConsumeRecord("aaa 1"));
        recordList.add(new MyConsumeRecord("bbb 2"));
        recordList.add(new MyConsumeRecord("ccc 3"));
    }
}
