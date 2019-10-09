package cn.didadu.sample.arithmetic;

/**
 * @author zhangjing
 * @date 2019-05-30
 */
public class Test {
    public static void main(String[] args) {
        int minMoney = 1;
        int maxMoney = 200 * 100;
        double random = Math.random();
        System.out.println(random);
        int redPacket = (int) (random * (maxMoney - minMoney) + minMoney);
        System.out.println(redPacket);
    }
}
