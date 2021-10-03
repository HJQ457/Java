package IO;

import java.io.*;
import java.util.Scanner;

public class Pic {
    public static void main(String[] args) {
        up();

        Boolean exists = isExists("1.jpg");
        if (exists){
            System.out.println("已经存在，上传失败");
        }else {
            System.out.println("不存在");
        }
    }

    //定义一个方法，判断路径和格式是否正确
    public static void up(){
        Scanner scan = new Scanner(System.in);

        while (true){
            System.out.println("请输入路径：");

            String path = scan.nextLine();

            if(!path.endsWith(".png") && !path.endsWith(".jpg") && !path.endsWith(".bmp")){

                System.out.println("输入格式错误，请重新输入：");

            }else {

                File file = new File(path);

                if (!file.exists() && !file.isFile()){
                    System.out.println("路径不正确，重新输入：");
                }else {
                    break;
                }
            }
        }
    }


    //定义一个方法，判断文件是否存在
    public static Boolean isExists(String path){
        File file = new File("C:\\Users\\HJQ\\Desktop");
        String[] names = file.list();
        for (String name : names) {
            if (name.equals(path)){
                return true;
            }
        }
        return false;

    }

    //定义方法，用来上传头像
    public static void uploadFile(File path) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("path"));

        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("C:\\Users\\HJQ\\Desktop" + path.getName()));

        int len;

        while ((len = bis.read()) != -1){
            bos.write(len);
        }

        bos.close();
        bis.close();

        System.out.println("上传成功");
    }
}