package ReflectDemol1;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Reflect1 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class clazz = Class.forName("ReflectDemol1.Student");
        Constructor con1 = clazz.getConstructor();
        System.out.println(con1);

        Constructor con2 = clazz.getConstructor(String.class);
        System.out.println(con2);

        Constructor con3 = clazz.getDeclaredConstructor(int.class);
        System.out.println(con3);

        System.out.println("***********");

        Constructor[] cons = clazz.getConstructors();
        for (Constructor con:cons){
            System.out.println(con);
        }

        System.out.println("***********");

        Constructor con4 = clazz.getConstructor(String.class);
        System.out.println(con4);

        System.out.println(con4.getName());

        Student stu = (Student) con4.newInstance("张三");
    }
}
