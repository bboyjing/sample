package cn.didadu.sample.arithmetic;

import scala.Int;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangjing
 * @date 2019-05-31
 */
public class TwoSum {

    /**
     * 时间复杂度为 O(N^2)
     * @param nums
     * @param target
     * @return
     */
    public static int[] getTwo1(int[] nums,int target){
        int[] result = null;
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            for (int j = nums.length -1 ;j >=0 ;j--){
                int b = nums[j];
                if (i != j && (a + b) == target) {
                    result = new int[]{i, j} ;
                }
            }
        }
        return result;
    }

    /**
     * 时间复杂度 O(N)
     * 利用Map Key存放目标值和当前值的差值，value 就是当前的下标
     * 每次遍历是 查看当前遍历的值是否等于差值，如果是等于，说明两次相加就等于目标值。
     * 然后取出 map 中 value ，和本次遍历的下标，就是两个下标值相加等于目标值了。
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] getTwo2(int[] nums,int target){
        int result[] = new int[2];
        Map<Integer, Integer> map = new HashMap<>(2);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                result = new int[]{map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        return result;
    }

    public static void main(String[] args) {
        int a[] = new int[]{1, 2, 3, 4, 5};
        int result[] = getTwo2(a, 5);

        for (int i: result) {
            System.out.println(i);
        }
    }
}
