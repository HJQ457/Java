package cn.itcast.demo2;

import java.util.*;

public class SendPokerTest {
    public static void main(String[] args) {
        //买牌
        HashMap<Integer, String> pokers = new HashMap<>();

        ArrayList<Integer> list = new ArrayList<>();

        String[] colors = {"♠","♥","♣","♦"};
        String[] numbers = {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
        int num = 0;

        for (String number : numbers) {
            for (String color : colors) {
                String poker = color + number;
                pokers.put(num,poker);
                list.add(num);
                num++;
            }
        }

        pokers.put(num,"小王");
        list.add(num);
        num++;

        pokers.put(num,"大王");
        list.add(num);

        System.out.println("所有：" + pokers);
        System.out.println("编号：" + list);

        //洗牌
        Collections.shuffle(list);
        System.out.println("洗好牌后，编号为：" + list);

        //发牌
        ArrayList<Integer> xx = new ArrayList<>();
        ArrayList<Integer> yy = new ArrayList<>();
        ArrayList<Integer> zz = new ArrayList<>();
        ArrayList<Integer> dipai = new ArrayList<>();

        for (int i = 0;i < list.size();i++){
            Integer pokerNum = list.get(i);
            if (i >= list.size() - 3){
                dipai.add(pokerNum);
            }else if (i % 3 == 0){
                xx.add(pokerNum);
            }
            else if (i % 3 == 1){
                yy.add(pokerNum);
            }
            else if (i % 3 == 2){
                zz.add(pokerNum);
            }
        }

        System.out.println("xx：" + xx);
        System.out.println("yy：" + yy);
        System.out.println("zz：" + zz);



    }
}
