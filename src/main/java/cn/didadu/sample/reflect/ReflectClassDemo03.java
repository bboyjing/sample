package cn.didadu.sample.reflect;

import java.util.HashSet;
import java.util.Set;

/**
 * 调用 Object 的 getClass 方法
 * @author zhangjing
 * @date 2019-03-29
 */
public class ReflectClassDemo03 {
    enum E{A, B}

    public static void main(String[] args) {
        Class c1 = "foo".getClass();
        System.out.println(c1.getCanonicalName());

        Class c2 = ReflectClassDemo03.E.A.getClass();
        System.out.println(c2.getCanonicalName());

        byte[] bytes = new byte[1024];
        Class c3 = bytes.getClass();
        System.out.println(c3.getCanonicalName());

        Set<String> set = new HashSet<>();
        Class c4 = set.getClass();
        System.out.println(c4.getCanonicalName());
    }
}
