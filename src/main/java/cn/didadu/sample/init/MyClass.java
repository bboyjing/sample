package cn.didadu.sample.init;

/**
 * @author zhangjing
 * @date 2019-05-06
 */
public abstract class MyClass {
    protected long plong;

    public MyClass() {
        plong = (long)'C';
    }

    public MyClass(long x) {
        plong = x;
    }
}
