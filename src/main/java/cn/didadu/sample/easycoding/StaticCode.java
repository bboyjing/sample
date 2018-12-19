package cn.didadu.sample.easycoding;

/**
 * @author zhangjing
 * @date 2018/11/1
 */
public class StaticCode {
    // prior 必须定义在last前边，否则编译出错：illegal forward reference
    static String prior = "done";

    // 依次调用f()的结果，三木运算符为true，执行g()，最后赋值成功
    static String last = f() ? g() : prior;

    public static boolean f() {
        return true;
    }

    public static String g() {
        return "hello world";
    }

    static {
        // 静态代码块可以访问静态变量和静态方法
        System.out.println();
        g();
    }
}
