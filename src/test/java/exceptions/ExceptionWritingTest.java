package exceptions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;

public class ExceptionWritingTest {

    @Disabled
    @Test
    public void testExceptionToStringMethod() {
        try {
            String string = null;
            string.length();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
//            System.out.println(e.getMessage());
            System.out.println(e);
        }
    }

    @Disabled
    @Test
    public void testIfLoopCanContinueWhenException() {
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println("This is message " + i);

                throw new Exception("TestException");
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    @Test
    public void testReturnValueWhenException() {
        for (int i = 0; i < 5; i++) {
            System.out.println("This is message " + returnValueAfterException(i));
        }
    }

    public int returnValueAfterException(int i) {
        try {
            throw new Exception("TestException");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

}
