package cn.didadu.sample.genericity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangjing
 * @date 2018/11/23
 */
public class ListNotGeneric {
    public static void main(String[] args) {
        // 第一段：泛型出现之前的集合定义方式
        List a1 = new ArrayList();
        a1.add(new Object());
        a1.add(new Integer(111));
        a1.add(new String("hello all"));
        System.out.println(a1);

        // 第二段：把a1引用赋值给a2，注意a2与a1的区别是增加了泛型限制<Object>
        List<Object> a2 = a1;
        a2.add(new Object());
        a2.add(new Integer(222));
        a2.add(new String("hello a2a2"));
        System.out.println(a2);

        // 第三段：把a1引用赋值给a3，注意a3与a1的区别是增加了泛型限制<Integer>
        List<Integer> a3 = a1;
        a3.add(333);
        // 下面两行编译失败
        // a3.add(new Object());
        // a3.add(new String("hello a3a3"));
        System.out.println(a3);

        // 第四段：把a1引用赋值给a4，a1与a4的区别是增加了通配符
        List<?> a4 = a1;
        // 允许删除和清除元素
        a1.remove(0);
        a4.clear();
        System.out.println(a4);
        // 编译出错，不允许增加任何元素
        // a4.add(new Object());

        // 无法通过编译
        List<Integer> intlist = new ArrayList<>(3);
        intlist.add(1111);
        // List<Object> objectList = intlist;
    }


    public static void wrongSample() {
//        JSONObject jsonObject = JSONObject.f
    }
}
