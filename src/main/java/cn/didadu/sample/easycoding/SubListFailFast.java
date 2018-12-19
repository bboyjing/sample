package cn.didadu.sample.easycoding;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangjing
 * @date 2018/11/29
 */
public class SubListFailFast {
     public static void main(String[] args) {
         List masterList = new ArrayList();
         masterList.add("one");
         masterList.add("two");
         masterList.add("three");
         masterList.add("four");
         masterList.add("five");

         // subList无法序列化，因为subList返回的是内部类，
         List branchList = masterList.subList(0, 3);

         // 下方三行代码，如果不注释掉，则会导致branchList操作出现异常
         // masterList任何关于元素个数的修改操作都会导致branchList的增、删、改、查抛出异常
         // masterList.remove(0);
         // masterList.add("ten");
         // masterList.clear();

         // 下方四行全部能够正确执行
         branchList.clear();
         branchList.add("six");
         branchList.add("seven");
         branchList.remove(0);

         // 正常遍历结束：只有一个元素: seven
         for (Object t : branchList) {
             System.out.println(t);
         }

         // 子列表修改导致主列表也被改动，输出：[seven, four, five]
         System.out.println(masterList);
     }
}
