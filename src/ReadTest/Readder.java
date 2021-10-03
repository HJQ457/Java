package ReadTest;

import java.io.*;

public class Readder {
    public static void main(String[] args) throws IOException {

        FileReader fr = new FileReader("D:\\workspace\\1.txt");

        int read = fr.read();

        while (read != -1){
            System.out.println((char)read);
            read = fr.read();
        }

        fr.close();
    }
}
