package Reflect;

public class Student {

    private String name;
    int age;
    public int id;

    public Student() {
    }

    public Student(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    private Student(String name){
        this.name = name;
    }

    public void show1(){
        System.out.println("公共空参");
    }


    public void show2(int a){
        System.out.println("公共带参方法，传入的参数是：" + a);
    }


    private int show3(int a,int b){
        System.out.println("私有带参方法");
        return a + b;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
