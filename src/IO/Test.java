package IO;

import java.io.File;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException, InterruptedException {
        File file1 = new File("C:\\Users\\HJQ\\Desktop\\新建文本文档.txt");

        //新建文件，删除文件
//        File file2 = new File("C:\\Users\\HJQ\\Desktop\\1.docx");
//        boolean newFile = file2.createNewFile();
//        Thread.sleep(3000);
//        file2.delete();


        //新建文件夹
//        File file3 = new File("C:\\Users\\HJQ\\Desktop\\2");
//        boolean mkdir = file3.mkdir();


        //新建多级文件夹
        File file4 = new File("C:\\Users\\HJQ\\Desktop\\a\\b\\c");
        boolean mkdirs = file4.mkdirs();


        //绝对路径
        System.out.println("绝对路径" + file1.getAbsoluteFile());


        //相对路径
        System.out.println("相对路径" + file1.getPath());


        //文件名
        System.out.println("文件名" + file1.getName());


        //获取文件夹下所有文件
        File file5 = new File("D:\\note\\src\\IO");
        String[] list = file5.list();
        for (String name : list) {
            System.out.println(name);
        }

        File[] file6 = file5.listFiles();
        for (File file : file6) {
            System.out.println(file);
        }
    }
}
