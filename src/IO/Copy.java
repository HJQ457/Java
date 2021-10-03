package IO;

import java.io.*;

public class Copy {
    public static void main(String[] args) throws IOException {

        //创建输入流
        FileReader fr = new FileReader("C:\\Users\\HJQ\\Desktop\\新建文本文档.txt");

        //创建输出流
        FileWriter fw = new FileWriter("C:\\Users\\HJQ\\Desktop\\copy.txt");


//        //方法一：
//
//        //定义变量，记录读取的内容
//        int len;
//
//        //循环读取，并将读取的内容赋值给变量
//        while ((len = fr.read()) != -1){
//
//            //写入本地文件
//            fw.write(len);
//        }






//        //方法二：
//
//        //定义字符数组
//        char[] chs = new char[2048];
//
//        //记录读取到的有效字符
//        int len;
//
//        //循环读取，并将读取的内容赋值给变量
//        while ((len = fr.read(chs)) != -1){
//            fw.write(chs,0,len);
//        }






//        //方法三：
//
//        BufferedReader br = new BufferedReader(fr);
//        BufferedWriter bw = new BufferedWriter(fw);
//
//        int len;
//
//        //Buffered不必使用char方法
//        while ((len = br.read()) != -1){
//            bw.write(len);
//        }
//
//        br.close();
//        bw.close();






        //方法四：

        BufferedReader br = new BufferedReader(fr);
        BufferedWriter bw = new BufferedWriter(fw);

        String str;

        //按行读取
        while ((str = br.readLine()) != null){
            bw.write(str);

            //换行
            bw.newLine();
        }

        br.close();
        bw.close();






        //关闭流
        fr.close();
        fw.close();
    }
}
