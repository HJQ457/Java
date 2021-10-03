package Reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectDemol1 {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException {

        Class clazz = Student.class;
        Constructor con = clazz.getConstructor();
        Student stu = (Student) con.newInstance();
        System.out.println(stu);

        //空参
        Method method1 = clazz.getMethod("show1");
        System.out.println(method1);
        System.out.println(method1.getName());
        method1.invoke(stu);

        //带参
        Method method2 = clazz.getMethod("show2", int.class);
        method2.invoke(stu,5);

        //私有
        Method method3 = clazz.getDeclaredMethod("show3", int.class, int.class);
        //暴力反射
        method3.setAccessible(true);
        int sum = (int)method3.invoke(stu,10,20);
        System.out.println(sum);

        //获取当前类及其父类声明为public的方法
        Method[] methods = clazz.getMethods();
        for (Method m:methods){
            System.out.println(m);
        }

        System.out.println();

        //获取当前类所有方法
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method m1:declaredMethods){
            System.out.println(m1);
        }

        Method[] declare = clazz.getDeclaredMethods();
        for (Method m:declare){
            Annotation[] annos = m.getAnnotations();
            for (Annotation a:annos){
                System.out.println(a);
            }
        }

        System.out.println();

        //获取当前类所有构造器
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor c:declaredConstructors){
            System.out.println(c);
        }
    }
}
