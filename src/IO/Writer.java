package IO;

import java.io.FileWriter;
import java.io.IOException;

public class Writer {
    public static void main(String[] args) throws IOException {
        FileWriter writer = new FileWriter("C:\\Users\\HJQ\\Desktop\\新建文本文档.txt");

        writer.write("aa");

        char[] chs = {'H','J','Q'};
        //writer.write(chs);

        writer.write(chs,0,2);

        writer.close();
    }
}
