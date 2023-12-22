package Moshi;

/*
单例模式  饿汉式
 */
public class Singleton {
    private Singleton(){}
    private final static Singleton instance = new Singleton();
    public static Singleton getInstance(){
        return instance;
    }
}
