package picture;

import java.io.File;
import java.security.PrivilegedExceptionAction;
import java.util.Scanner;

public class UploadFile {
    public static void main(String[] args) {
        File path = getPath();
        System.out.println(path);

        boolean flag = isExists(path.getName());
        if(flag){
            System.out.println("已经存在，上传失败");
        }else {
            System.out.println("我马上上传");
        }
    }

    public static File getPath() {
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("请录入图片路径");
            String path = sc.nextLine();

            if (!path.endsWith(".jpg") && !path.endsWith(".png") && !path.endsWith(".bmp")){
                System.out.println("不是图片，请重新录入：");
                continue;
            }

            File file = new File(path);
            if (file.exists() && file.isFile()){
                return file;
            }else {
                System.out.println("路径不合法，请重新输入：");
            }
        }
    }

    public static boolean isExists(String path){
        File file = new File("lib");
        String[] names = file.list();
        for (String name:names){
            if (name.equals(path)){
                return true;
            }
        }
        return false;
    }

    public static void uploadFile(File path){

    }
}
