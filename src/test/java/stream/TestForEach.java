package stream;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestForEach {

    @Test
    public void testContinueForEach() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        list.forEach(s-> {
            if (s.equals("b")) {
                return;
            }
            System.out.println(s);
        });
    }
}
