package singleton;

import org.junit.Test;
import static org.junit.Assert.*;

public class testHungryMan {

    /**
     * 测试在单线程下饿汉方式是否能实现单例模式
     * 若判真断言通过说明单例模式实现了单例模式
     */
    @Test
    public void singleThreadTest(){
        //分别创建两个对象来获取饿汉单例模式类
        HungryMan instance1 = HungryMan.getInstance();
        HungryMan instance2 = HungryMan.getInstance();
        //判断两个对象是否是相同的对象
        assertTrue(instance1 == instance2);
    }

    /**
     * 测试在多线程下饿汉方式是否能实现单例模式
     * 若有控制台显示只有一个线程创建了新实例，则说明实现了单例模式
     * 否则表示未实现
     */
    @Test
    public void multithreadingTest(){
        //依次创建10个线程来获取实例，检验是否会调用同一个实例
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                HungryMan.getInstance();
            }).start();
        }
    }


}
