package IO;

import java.io.*;

public class Stream {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("D:\\就业指导\\1.jpg");

        FileOutputStream fos = new FileOutputStream("C:\\Users\\HJQ\\Desktop\\2.jpg");

//        //方法一：
//        int len;
//
//        while ((len = fis.read()) != -1){
//            fos.write(len);
//        }





//        //方法二：
//        //字节流byte
//        byte[] chs = new byte[2048];
//        int len;
//
//        while ((len = fis.read(chs)) != -1){
//            fos.write(chs,0,len);
//        }





//        //方法三：
//        BufferedInputStream bis = new BufferedInputStream(fis);
//        BufferedOutputStream bos = new BufferedOutputStream(fos);
//
//        int len;
//
//        while ((len = bis.read()) != -1){
//            bos.write(len);
//        }




        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        int len;

        while ((len = bis.read()) != -1){
            bos.write(len);
        }

        bis.close();
        bos.close();

        fis.close();
        fos.close();
    }
}
