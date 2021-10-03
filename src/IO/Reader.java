package IO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader("C:\\Users\\HJQ\\Desktop\\新建文本文档.txt");

//        int data;
//        while ((data = reader.read()) != -1){
//            System.out.print((char) data);
//        }


//        int data1 = reader.read();
//        while (data1 != -1){
//            System.out.print((char) data1);
//            data1 = reader.read();
//        }


        char[] chs = new char[3];
        int len;
        while ((len = reader.read(chs)) != -1){
            String s = new String(chs, 0, len);
            System.out.println(s);
        }

        reader.close();
    }
}
