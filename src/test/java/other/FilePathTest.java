package other;

import java.nio.file.FileSystems;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;

public class FilePathTest {

    @Disabled
    @Test
    public void testPrint(){
        System.out.println("testPrint");
    }

    @Test
    public void printCurrent() {
        System.out.println(Paths.get(".").toAbsolutePath().normalize().toString());
        System.out.println(Paths.get(".").toAbsolutePath());
        System.out.println(Paths.get(".").toAbsolutePath().normalize());

        System.out.println(FileSystems.getDefault().getPath("."));
    }
}
