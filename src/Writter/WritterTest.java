package Writter;

import java.io.FileWriter;
import java.io.IOException;

public class WritterTest {
    public static void main(String[] args) throws IOException {

        FileWriter fw = new FileWriter("D:\\workspace\\1.txt");

        char[] chs = {'a', 'b', 'b', 'f'};

        //fw.write(chs);

        fw.write(chs,1,3);

        fw.close();
    }
}
