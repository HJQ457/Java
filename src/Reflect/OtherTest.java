package Reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class OtherTest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz = Student.class;
        //Class superclass = clazz.getSuperclass();
        //System.out.println(superclass);

        Constructor cons = clazz.getConstructor();
        Student S = (Student)cons.newInstance();

        Method method = clazz.getMethod("show1");
        method.invoke(S);

        Package aPackage = clazz.getPackage();
        System.out.println(aPackage);

        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation a:annotations){
            System.out.println(a);
        }
    }
}
