package singleton;

import org.junit.Test;

/**
 * 饿汉式单例实现
 * 该方式是线程安全的
 */
public class HungryMan {
    //定义唯一类实例，该实例在类加载时就已经创建
    private static HungryMan instance = new HungryMan();

    //构造器私有化
    private HungryMan(){
        //创建新实例时输出当前线程的名称（用于测试多线程下是否实现单例模式）
        System.out.println("线程【"+Thread.currentThread().getName()+"】创建了新实例");
    }

    //定义一个用户获取类唯一实例的类方法
    public static HungryMan getInstance(){
        //返回在类加载时就创建好的唯一类实例
        return instance;
    }

    //用来测试是否实现单例
    public static void main(String[] args) {
        /* 测试单线程下，是否能实现单例模式 */
        System.out.println("测试单线程下，是否能实现单例模式");
        HungryMan instance1 = HungryMan.getInstance();
        HungryMan instance2 = HungryMan.getInstance();
        if(instance1 == instance2){
            System.out.println("它俩是同一个实例一个");
        }else{
            System.out.println("它俩不是同一个实例一个");
        }
        ////////////////////////////////////////////////////

        /* 测试多线程下是否能实现单例模式 */
        System.out.println("测试多线程下，是否能实现单例模式");
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                HungryMan.getInstance();
            }).start();
        }
        ////////////////////////////////////////////////////
    }

}
