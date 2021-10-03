package File;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FIleTest {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\workspace\\1.txt");

        boolean newFile = file.createNewFile();

        File file1 = new File("D:\\workspace\\aaa");
        boolean mkdir = file1.mkdir();

        System.out.println(file.isFile());
        System.out.println(file1.isDirectory());
        System.out.println(file.getAbsoluteFile());
    }
}
