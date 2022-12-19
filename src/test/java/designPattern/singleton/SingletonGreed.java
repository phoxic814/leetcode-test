package designPattern.singleton;

/**
 * 貪婪法預先建造
 */
public class SingletonGreed {

    private static final SingletonGreed instance  = new SingletonGreed();

    // private constructor，這樣其他物件就沒辦法直接用new來取得新的實體
    private SingletonGreed(){}

    public static SingletonGreed getInstance(){
        return instance;
    }

}
