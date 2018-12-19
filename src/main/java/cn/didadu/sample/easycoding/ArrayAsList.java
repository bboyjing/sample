package cn.didadu.sample.easycoding;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhangjing
 * @date 2018/11/22
 */
public class ArrayAsList {
    public static void main(String[] args) {
        String[] stringArray = new String[3];
        stringArray[0] = "one";
        stringArray[1] = "two";
        stringArray[2] = "three";

        List<String> stringList = Arrays.asList(stringArray);
        // 修改转换后的集合，成功地把第一个元素"one"改成"oneList"
        stringList.set(0, "oneList");
        System.out.println(stringList.get(0));
        // 素组的值也随之修改了
        System.out.println(stringArray[0]);

        // 这是重点：以下三行可以通过编译，但是都会抛出运行时异常：java.lang.UnsupportedOperationException
        stringList.add("four");
        stringList.remove(2);
        stringList.clear();

    }

}
