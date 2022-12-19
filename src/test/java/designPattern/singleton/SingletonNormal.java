package designPattern.singleton;

public class SingletonNormal {

    private static SingletonNormal instance;

    private SingletonNormal() {}

    // 多執行緒時使用synchronized保證Singleton一定是單一的
    public static synchronized SingletonNormal getInstance() {
        if (instance == null) {
            instance = new SingletonNormal();
        }

        return instance;
    }
}
