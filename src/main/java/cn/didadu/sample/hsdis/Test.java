package cn.didadu.sample.hsdis;

/**
 * @author zhangjing
 * @date 2019-03-25
 */
public class Test {
    public int a = 3;
    static Integer si = 6;
    String s = "Hello World!";
    static final int aa = 10;

    public static void main(String[] args) {
        Test test = new Test();
        test.a = 8;
        si = 9;

    }

    private void test() {
        this.a = a;
    }
}
