package cn.didadu.sample.easycoding;

import java.lang.reflect.Field;

/**
 * @author zhangjing
 * @date 2018/11/5
 */
public class ClassTest {
    // 数组类型有一个魔法属性：length来获取数组长度
    private static int[] array = new int[3];
    private static int length = array.length;
    private static Class<One> one = One.class;

    // 任何小写class定义的类，也有一个魔法属性：class，来获取此类的大些Class类对象
    private static Class<Another> another = Another.class;

    public static void main(String[] args) throws Exception {
        // 通过newInstance方法创建One和Another对象的类对象
        // one.newInstance()方法在JDK9中已经过时
        One oneObject = one.getDeclaredConstructor().newInstance();
        oneObject.call();

        Another anotherObject = another.getDeclaredConstructor().newInstance();
        anotherObject.speak();

        // 通过one这个大写的Class对象，获取私有成员属性对象Field
        Field privateFieldInOne = one.getDeclaredField("inner");
        // 设置私有对象可以访问和修改
        privateFieldInOne.setAccessible(true);
        privateFieldInOne.set(oneObject, "world changed.");
        System.out.println(oneObject.getInner());
    }
}

class One {
    private String inner = "time files.";

    public void call() {
        System.out.println("hello world.");
    }

    public String getInner() {
        return inner;
    }
}

class Another {
    public void speak() {
        System.out.println("easy coding.");
    }
}


