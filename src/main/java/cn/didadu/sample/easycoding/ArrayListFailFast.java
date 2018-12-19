package cn.didadu.sample.easycoding;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author zhangjing
 * @date 2018/12/1
 */
public class ArrayListFailFast {
    public static void main(String[] arg) {
        testCOW();
    }

    public static void removeByFor() {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        for (String s : list) {
            if ("two".equals(s)) {
                list.remove(s);
            }
        }
        /*
         * 编译正确、执行正确，输出[one, three]，但这只是一个巧合
         * 在集合遍历时维护一个初始值为0的游标cursor，从头到尾地进行扫描，在cursor==size时，退出遍历
         * 如上，执行remove这个元素后，所有元素往前拷贝，size=size-1即为2，这时cursor也等于2.
         * 在执行hasNext()时，结果为false，退出循环体，并没有机会执行到next()的第一行代码。
         */
        System.out.println(list);
    }

    public static void removeByIterator() {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if ("one".equals(item)) {
                /*
                 * iterator可以安全地删除元素
                 */
                iterator.remove();
            }
        }
        System.out.println(list);
    }

    public static void testCOW() {
        List<Long> copy = new CopyOnWriteArrayList<>();
        long start = System.nanoTime();
        /**
         * 非常耗时
         * 对CopyOnWrite的写操作建议批量进行
         */
        for (int i = 0; i < 20 * 10000; i++) {
            copy.add(System.nanoTime());
        }
    }

}
