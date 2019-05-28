package cn.didadu.sample.reflect;

/**
 * 直接获取某一个对象的 class
 * @author zhangjing
 * @date 2019-03-29
 */
public class ReflectClassDemo02 {
    public static void main(String[] args) {
        boolean b;
        // 编译错误
        // Class c1 = b.getClass();
        Class c1 = boolean.class;
        System.out.println(c1.getCanonicalName());

        Class c2 =  java.io.PrintStream.class;
        System.out.println(c2.getCanonicalName());

        Class c3 = int[][][].class;
        System.out.println(c3.getCanonicalName());
    }
}
