package Thread;

public class ThreadTest {
    public static void main(String[] args) {
        MThread mThread1 = new MThread();
        MThread mThread2 = new MThread();

        Thread t1 = new Thread(mThread1);
        Thread t2 = new Thread(mThread2);

        //t1.start();
        //t2.start();

        StringBuffer stringBuffer = new StringBuffer(5);
        stringBuffer.append(5);
        stringBuffer.append(10);
        System.out.println(stringBuffer);

        Integer integer = new Integer(100);
        System.out.println(Integer.valueOf(integer));
    }
}

class MThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0;i < 100;i++){
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
