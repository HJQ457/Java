package Map;

import java.util.*;

public class Student {
    public Student(String name, int i) {
    }

    public static void main(String[] args) {
        HashMap<Integer, Student> map = new HashMap<>();

        Student s1 = new Student("zhangsan",23);
        Student s2 = new Student("lisi",24);
        Student s3 = new Student("wangwu",25);
        Student s4 = new Student("zhangsan",23);

        map.put(1,s1);
        map.put(2,s2);
        map.put(3,s3);
        map.put(4,s4);

        System.out.println(map);
        System.out.println(map.get(2));

        Set<Integer> keys = map.keySet();

//        Iterator<Integer> it = keys.iterator();
//        while (it.hasNext()) {
//            Integer key = it.next();
//            Student value = map.get(key);
//            System.out.println(key +" " + value);
//        }

        for (Integer key : keys) {
            Student va = map.get(key);
            System.out.println(key + " " + va);
        }
    }
}
