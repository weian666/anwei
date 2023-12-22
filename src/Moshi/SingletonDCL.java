package Moshi;

public class SingletonDCL {
    private SingletonDCL(){}
    private volatile static SingletonDCL instance;
    public static SingletonDCL getInstance(){
        if(instance == null){
            synchronized(SingletonDCL.class){
                if(instance == null){
                    instance = new SingletonDCL();
                }
            }
        }
        return instance;
    }
}
