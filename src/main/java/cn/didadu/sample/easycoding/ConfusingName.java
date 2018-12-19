package cn.didadu.sample.easycoding;

/**
 * @author zhangjing
 * @date 2018/11/1
 */
public class ConfusingName {
    private int alibaba;

    public ConfusingName(int alibaba) {
        this.alibaba = alibaba;
    }

    public int getAlibaba() {
        return alibaba;
    }

    public void setAlibaba(int alibaba) {
        this.alibaba = alibaba;
    }

    public static void main(String[] args) {
        A a = new A(1);
        // 如果子类不重写，getter/setter方法，则直接调用父类的getter/setter方法，将会打印出1
        // 如果子类重写父类的getter/setter方法，则调用子类的getter/setter方法，将会打印出2
        System.out.println(a.getAlibaba());
    }

}

class A extends ConfusingName {
    private int alibaba;

    // 重写父类的getter/setter对结果有完全的影响
    @Override
    public int getAlibaba() {
        return alibaba;
    }

    @Override
    public void setAlibaba(int alibaba) {
        this.alibaba = alibaba;
    }

    public A(int alibaba) {
        super(alibaba);
        this.alibaba = alibaba + 1;
    }
}