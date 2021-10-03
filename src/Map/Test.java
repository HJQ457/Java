package Map;

import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        Student s = new Student("Tom", 50);


        HashMap<Object, Object> map = new HashMap<>();


        map.put("Tom",s);


        Object target = map.get("Tom");


        System.out.println(target);
    }
}

class Student {
    public String name;
    public int score;


    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }


    public String toString(){
        return "student{" + "name:" + name + ",score:" +score + "}";
    }
}
