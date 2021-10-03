package Proxy;

import java.lang.reflect.Proxy;

interface Human{
    String getBelief();
    void eat(String food);
}

class SuperMan implements Human{

    @Override
    public String getBelief() {
        return "I believe i can fly";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃" + food);
    }
}

//class ProxyFactory{
//    public static Object getProxyInstance(Object obj){//obj:被代理类
//        //Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),handler)
//    }
//}

public class ProxyTest {
}
