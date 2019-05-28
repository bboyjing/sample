package cn.didadu.sample.reflect;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangjing
 * @date 2019-04-01
 */
public class InstanceofDemo {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        // 用 instanceof 关键字
        if (arrayList instanceof List) {
            System.out.println("ArrayList is List");
        }
        // 用 Class 对象的 isInstance 方法（它是一个 Native 方法）
        if (List.class.isInstance(arrayList)) {
            System.out.println("ArrayList is List");
        }
    }
}
