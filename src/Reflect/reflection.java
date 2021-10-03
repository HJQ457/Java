package Reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class reflection {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<Student> clazz = Student.class;

        //创建运行类的对象
        Student stu = (Student) clazz.newInstance();

        //获取public属性
        Field id = clazz.getField("id");

        //设置属性
        id.set(stu,100);

        //获取属性
        int PId = (int)id.get(stu);
        System.out.println(PId);


        //获取private属性
        Field name = clazz.getDeclaredField("name");

        name.setAccessible(true);
        name.set(stu,"Tom");

        System.out.println(name.get(stu));

        //获取构造器
        Constructor<Student> constructor = clazz.getDeclaredConstructor(String.class);
        constructor.setAccessible(true);
        Student tom = constructor.newInstance("Tom");
        System.out.println(tom);
    }
}
