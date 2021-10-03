package ReflectDemol1;

public class Student {

    public Student(){
    }

    public Student(String name){
        System.out.println("您录入的name的值是：" + name);
    }

    private Student(int age){
        System.out.println("您录入的age的值是：" + age);
    }
}
