package ReflectDemol;

public class Student {
    public static void main(String[] args) throws ClassNotFoundException {
        Student stu = new Student();

        //获取字节码：
        //1：Class clazz1 = 对象名.getClass();
        Class clazz1 = stu.getClass();

        //2：Class clazz2 = 类名.class;
        Class clazz2 = Student.class;

        //3.Class clazz3 = Class.forName("类的正名");
        Class clazz3 = Class.forName("ReflectDemol.Student");

        System.out.println(clazz1 == clazz2);
        System.out.println(clazz2.equals(clazz3));
    }
}
