package cn.didadu.sample.genericity;

/**
 * @author zhangjing
 * @date 2018/5/15
 */

class Base { }

class Derived extends Base { }

class Super {
    Base get() {
        return new Base();
    }
}

/**
 * 协变返回类型
 * 子类型覆盖父类型方法时，子类型方法的返回类型是父类型方法返回类型的子类型
 * 我们就把这个返回类型称作协变返回类型
 */
class Sub extends Super {
    // return type of overridden method is allowed to vary
    @Override
    Derived get() {
        return new Derived();
    }
}

public class Client {
    public static void main(String[] args) {
        Super sup = new Sub();
        Base base = sup.get();
        System.out.println(base.getClass().getSimpleName());
    }
}
