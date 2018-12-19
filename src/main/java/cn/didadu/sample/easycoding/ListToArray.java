package cn.didadu.sample.easycoding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangjing
 * @date 2018/11/22
 */
public class ListToArray {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>(3);
        list.add("one");
        list.add("two");
        list.add("three");

        // 泛型丢失，无法使用String[]接收无参方法返回的结果
        // String[] array1 = list.toArray();
        Object[] array1 = list.toArray();

        // arrray2数组长度小于元素个数，输出[null, null]
        String[] array2 = new String[2];
        list.toArray(array2);
        System.out.println(Arrays.asList(array2));

        // array3数组长度等于元素个数
        String[] array3 = new String[3];
        list.toArray(array3);
        System.out.println(Arrays.asList(array3));
    }
}
