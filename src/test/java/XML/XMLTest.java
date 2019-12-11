package XML;

import org.junit.jupiter.api.Test;

import java.io.*;

public class XMLTest {

    @Test
    public void testReadXmlFile(){
        File xmlFile = new File("/Users/j0l065j/Documents/temp/solrDocs/00085369992051.xml");
        try {
            Reader fileReader = new FileReader(xmlFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuilder sb = new StringBuilder();
            String line = bufferedReader.readLine();
            int i = 0;
            while (line != null) {
                sb.append(line).append("");
                line = bufferedReader.readLine();
                i++;
            }
            System.out.println("num of lines:" + i);
            String xml2String = sb.toString();
            System.out.println("XML to String using BufferedReader : ");
            System.out.println(xml2String);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
