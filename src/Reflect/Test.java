package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) throws Exception {
        Class<Student> clazz = Student.class;
        Constructor<Student> con = clazz.getConstructor();
        Student student = con.newInstance();

        student.setScore(10);
        
        System.out.println(student);

        System.out.println(clazz.getField("score"));

        System.out.println(clazz.getField("name"));

        System.out.println(clazz.getDeclaredField("grade"));

        Method setGrade = clazz.getMethod("setGrade", int.class);
        setGrade.invoke(student,5);
        System.out.println(student);
    }
}

class Student extends Person {
    public int score;
    private int grade;

    public Student(){

    }

    public Student(int score,int grade){
        this.score = score;
        this.grade = grade;
    }
    
    public void setScore(int score){
        this.score = score;
    }

    public void setGrade(int grade){
        this.grade = grade;
    }


    public String toString(){
        return "Student{" + "score:" + score + "," + "grade:" + grade +"}";
    }
}

class Person {
    public String name;
}