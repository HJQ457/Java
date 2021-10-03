package IO;

import java.io.*;
import java.util.Scanner;

public class method {
    public static void main(String[] args) throws IOException {

        System.out.println("enter path1:");
        //Scanner scan1 = new Scanner(System.in);
        //String next1 = scan1.next();

        String next1 = new Scanner(System.in).next();
        String next2 = new Scanner(System.in).next();


        System.out.println("enter path2:");
        //Scanner scan2 = new Scanner(System.in);
        //String next2 = scan2.next();


        methods(next1,next2);
    }

    public static void methods(String path1,String path2) throws IOException {

        FileInputStream fis = new FileInputStream(path1);

        FileOutputStream fos = new FileOutputStream(path2);

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
