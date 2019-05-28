package cn.didadu.sample.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author zhangjing
 * @date 2019-04-01
 */
public class NewInstanceDemo {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class c1 = StringBuilder.class;
        StringBuilder sb = (StringBuilder) c1.newInstance();
        sb.append("aa");
        System.out.println(sb.toString());

        // 获取String对应的Class对象
        Class<?> c2 = String.class;
        // 获取String类带一个String参数的构造器
        Constructor constructor = c2.getConstructor(String.class);
        // 根据构造器创建实例
        String str2 = (String) constructor.newInstance("bbb");
        System.out.println(str2);
    }
}
