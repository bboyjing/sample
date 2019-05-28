package cn.didadu.sample.hsdis;

import net.sf.ehcache.pool.sizeof.SizeOf;
import net.sf.ehcache.pool.sizeof.UnsafeSizeOf;

import java.lang.reflect.Field;

/**
 * @author zhangjing
 * @date 2019-04-15
 */
public class Child extends Father{
    public static void main(String[] args) {
        SizeOf sizeOf = new UnsafeSizeOf();
        // child输出的大小和父类一样大，但是没法直接访问父类声明的成员变量(无论是public还是private)
        Child child = new Child();
        Field[] fields = Child.class.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }

        System.out.println(sizeOf.sizeOf(child));

        System.out.println(child.getA());
        System.out.println(child.getB());
    }

}
