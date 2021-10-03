package copy;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class copyTest {
    public static void main(String[] args) throws IOException {

        FileReader fr = new FileReader("D:\\workspace\\1.txt");

        FileWriter fw = new FileWriter("D:\\workspace\\2.txt");

        int read = fr.read();

        while (read != -1){
            fw.write(read);
            read = fr.read();
        }

        fr.close();
        fw.close();
    }
}
