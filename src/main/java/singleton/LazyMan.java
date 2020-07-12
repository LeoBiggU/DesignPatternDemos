package singleton;

/**
 * 懒汉式单例实现
 * 这种实现方式是线程不安全的
 */
public class LazyMan {

    //定义一个变量用于存储创建好的类实例
    private static LazyMan instance = null;

    /**
     * 构造器私有化
     * 可以在内部控制创建实例的数量
     */
    private LazyMan(){
        //创建新实例时输出当前线程的名称（用于测试多线程下是否实现单例模式）
        System.out.println("线程【"+Thread.currentThread().getName()+"】创建了新实例");
    }

    /**
     * 为客户端提供实例的方法
     * @return 唯一类实例
     */
    public static LazyMan getInstance(){
        //判断内部定义的唯一类实例是否存在
        if(instance == null){
            //不存在就创建
            instance = new LazyMan();
        }
        return instance; //返回类实例
    }

}
