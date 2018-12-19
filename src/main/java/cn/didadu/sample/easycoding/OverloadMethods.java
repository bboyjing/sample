package cn.didadu.sample.easycoding;

/**
 * @author zhangjing
 * @date 2018/11/1
 */
public class OverloadMethods {

    /**
     * JVM在重载方法中，选择合适的目标方法的顺序如下：
     * 1、精确匹配
     * 2、如果是几本类型数据，自动转换成更大表示范围的基本类型
     * 3、通过自动拆箱和装箱
     * 4、通过子类向上转型机车呢个路线依次匹配
     * 5、通过可变参数匹配
     */
    public static void main(String[] args) {
        OverloadMethods overloadMethods = new OverloadMethods();
        overloadMethods.overLoadMethod(7);
    }

    // 第一种方法：无参
    public void overLoadMethod() {
        System.out.println("无参方法");
    }

    // 第二种方法：基本数据类型
    public void overLoadMethod(int param) {
        System.out.println("参数为基本类型int的方法");
    }

    // 第三种方法：包装数据类型
    public void overLoadMethod(Integer param) {
        System.out.println("参数为包装类型Integer的方法");
    }

    // 第四种方法：可变参数，可以接受0~那个Integer对象
    public void overLoadMethod(Integer... param) {
        System.out.println("可变参数方法");
    }

    // 第五种方法：Object方法
    public void overLoadMethod(Object param) {
        System.out.println("参数为Object的方法");
    }
}
