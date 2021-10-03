package Buffer;

import java.io.*;

public class BufferStream {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("D:\\就业指导\\1.jpg");
        FileOutputStream fos = new FileOutputStream("D:\\就业指导\\11.jpg");

        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        int len;

        while ((len = bis.read()) != -1){
            bos.write(len);
        }

        bis.close();
        bos.close();
        fos.close();
        fis.close();
    }
}
