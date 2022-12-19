package designPattern.singleton;

import org.junit.Test;

public class SingletonTest {

    @Test
    public void test() {
        SingletonGreed a = SingletonGreed.getInstance();
        SingletonGreed b = SingletonGreed.getInstance();
        System.out.println(a == b);
    }

    @Test
    public void testI() {
        SingletonNormal a = SingletonNormal.getInstance();
        SingletonNormal b = SingletonNormal.getInstance();
        System.out.println(a == b);
    }
}
