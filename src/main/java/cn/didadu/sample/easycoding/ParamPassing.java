package cn.didadu.sample.easycoding;

/**
 * @author zhangjing
 * @date 2018/10/31
 */
public class ParamPassing {
    private static int intStatic = 222;
    private static String stringStatic = "old string";
    private static StringBuilder stringBuilderStatic = new StringBuilder("old string builder");

    public static void main(String[] args) {
        // 实参调用
        method(intStatic);
        method(stringStatic);
        method(stringBuilderStatic, stringBuilderStatic);

        System.out.println(intStatic);
        method();
        // 无参方法之后，反而修改为888
        System.out.println(intStatic);
        // 输出依然是：old string
        System.out.println(stringStatic);
        System.out.println(stringBuilderStatic);
    }

    // A方法
    public static void method(int intStatic) {
        intStatic = 777;
    }

    // B方法
    public static void method() {
        intStatic = 888;
    }

    // C方法
    public static void method(String stringStatic) {
        // String类是immutable对象，String没有提供任何方法用于修改对象
        stringStatic = "new string";
    }

    // D方法
    public static void method(StringBuilder stringBuilderStatic1, StringBuilder stringBuilderStatic2) {
        // 直接使用参数引用修改对象
        stringBuilderStatic1.append(".method.first-");
        stringBuilderStatic2.append(".method.second-");

        // 引用重新复制
        stringBuilderStatic1 = new StringBuilder("new string builder");
        stringBuilderStatic1.append("new methods' append");
    }

}
