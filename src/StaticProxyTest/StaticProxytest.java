package StaticProxyTest;

import java.util.Scanner;

interface ClothFactory{
    void produceCloth();
}

//代理类
class ProxyClothFactory implements ClothFactory{

    private ClothFactory factory;//用被代理类对象实例化

    public ProxyClothFactory(ClothFactory factory){
        this.factory = factory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理工厂准备工作");

        factory.produceCloth();

        System.out.println("代理工厂收尾工作");
    }
}

//被代理类
public class StaticProxytest {

}

