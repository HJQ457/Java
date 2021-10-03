package Map;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class SendTest {
    public static void main(String[] args) {
        HashMap<Integer, String> pockers = new HashMap<>();

        ArrayList<Integer> list = new ArrayList<>();

        String[] colors = {"♠","♥","♣","♦"};
        String[] numbers = {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
        int num = 0;

        for (String number : numbers) {
            for (String color : colors) {
                String pocker = color + number;
                pockers.put(num,pocker);
                list.add(num);
                num++;
            }
        }

        pockers.put(num,"大王");
        list.add(num);
        num++;

        pockers.put(num,"小王");
        list.add(num);

        System.out.println("所有：" + pockers);
        System.out.println("编号：" + list);

        Collections.shuffle(list);

        ArrayList<Integer> xx = new ArrayList<>();
        ArrayList<Integer> yy = new ArrayList<>();
        ArrayList<Integer> zz = new ArrayList<>();
        ArrayList<Integer> dipai = new ArrayList<>();

        for (int i = 0;i < list.size();i++){
            Integer pockerNum = list.get(i);
            if (i >= list.size() - 3){
                dipai.add(pockerNum);
            }else if (i % 3 == 0){
                xx.add(pockerNum);
            }else if (i % 3 == 1){
                yy.add(pockerNum);
            }else if (i % 3 == 2){
                zz.add(pockerNum);
            }
        }

        System.out.println("xx：" + xx);
        System.out.println("yy：" + yy);
        System.out.println("zz：" + zz);
    }
}
