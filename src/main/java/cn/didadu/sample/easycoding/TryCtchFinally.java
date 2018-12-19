package cn.didadu.sample.easycoding;

/**
 * @author zhangjing
 * @date 2018/11/6
 */
public class TryCtchFinally {
    static int x = 1;
    static int y = 10;
    static int z = 100;

    public static void main(String[] args) {
        int value = finallyReturn();
        System.out.println("value=" + value);

        System.out.println("x=" + x);
        System.out.println("y=" + y);
        System.out.println("z=" + z);
    }

    public static int finallyReturn() {
        try {
            return ++x;
        } catch (Exception e) {
            return ++y;
        } finally {
            return ++z;
        }
    }
}
