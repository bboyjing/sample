package cn.didadu.sample.arithmetic;

import java.util.LinkedList;
import java.util.List;

/**
 * 红包算法
 * @author zhangjing
 * @date 2019-05-30
 */
public class RedPacket {
    /**
     * 生成红包最小值 1分
     */
    private static final int MIN_MONEY = 1;

    /**
     * 生成红包最大值 200人民币
     */
    private static final int MAX_MONEY = 200 * 100;

    /**
     * 小于最小值
     */
    private static final int LESS = -1;
    /**
     * 大于最大值
     */
    private static final int MORE = -2;

    /**
     * 正常值
     */
    private static final int OK = 1;

    /**
     * 最大的红包是平均值的 TIMES 倍，防止某一次分配红包较大
     */
    private static final double TIMES = 2.1F;

    private int recursiveCount = 0;

    public static void main(String[] args) {
        RedPacket redPacket = new RedPacket();
        List<Integer> redPackets = redPacket.splitRedPacket(20000, 100);
        System.out.println(redPackets);

        int sum = 0;
        for (Integer red : redPackets) {
            sum += red;
        }
        System.out.println(sum);
    }

    public List<Integer> splitRedPacket(int money, int count) {
        List<Integer> moneys = new LinkedList<>();

        // 金额检查，如果最大红包 * 个数 < 总金额；则需要调大最小红包 MAX_MONEY
        if (MAX_MONEY * count <= money) {
            System.err.println("请调大最小红包金额 MAX_MONEY=[" + MAX_MONEY + "]");
            return moneys ;
        }

        // 计算出最大红包
        int max = (int) ((money / count) * TIMES);
        max = max > MAX_MONEY ? MAX_MONEY : max;

        for (int i = 0; i < count; i++) {
            // 随机获取红包
            int redPacket = randomRedPacket(money, MIN_MONEY, max, count - i);
            moneys.add(redPacket);
            // 每次总金额减少
            money -= redPacket;
        }

        return moneys;
    }

    private int randomRedPacket(int totalMoney, int minMoney, int maxMoney, int count) {
        // 只有一个红包，直接返回
        if (count == 1) {
            return totalMoney;
        }

        // 红包金额一样
        if (minMoney == maxMoney) {
            return minMoney;
        }

        // 如果最大金额大于了剩余金额 则用剩余金额 因为这个 money 每分配一次都会减小
        maxMoney = maxMoney > totalMoney ? totalMoney : maxMoney;

        //在 minMoney到maxMoney 生成一个随机红包
        // Math.random()在0~1之间
        int redPacket = (int) (Math.random() * (maxMoney - minMoney) + minMoney);

        // 剩余金额
        int lastMoney = totalMoney - redPacket;

        int status = checkMoney(lastMoney, count - 1);

        if (OK == status) {
            return redPacket;
        }

        // 生成的红包金额太多了，minMoney~redPacket之间重新生成一个值
        if (LESS == status) {
            recursiveCount++;
            System.out.println("recursiveCount==" + recursiveCount);
            return randomRedPacket(totalMoney, minMoney, redPacket, count);
        }

        // 生成的红包金额太少了，在redPacket~maxMoney之间重新生成一个值
        if (MORE == status) {
            recursiveCount++;
            System.out.println("recursiveCount===" + recursiveCount);
            return randomRedPacket(totalMoney, redPacket, maxMoney, count);
        }

        return redPacket;
    }

    /**
     * 校验剩余的金额的平均值是否在 最小值和最大值这个范围内
     * @param lastMoney
     * @param count
     * @return
     */
    private int checkMoney(int lastMoney, int count) {
        double avg = (double) lastMoney / count;
        if (avg < MIN_MONEY) {
            return LESS;
        }

        if (avg > MAX_MONEY) {
            return MORE;
        }

        return OK;
    }
}
