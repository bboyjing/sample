package cn.didadu.sample.easycoding;

/**
 * @author zhangjing
 * @date 2018/12/14
 */
public class VolatileNotAtomic {
    private static volatile long count = 0L;
    private static final int NUMBER = 10000;

    public static void main(String[] args) {
        Thread subtractThread = new SubstractTread();
        subtractThread.start();

        for (int i = 0; i < NUMBER; i++) {
            synchronized (VolatileNotAtomic.class) {
                count++;
            }
        }

        // 等待减法线程结束
        while (subtractThread.isAlive()) {}
        System.out.println("count 最后的值为： " + count);
    }

    private static class SubstractTread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < NUMBER; i++) {
                synchronized (VolatileNotAtomic.class) {
                    count--;
                }
            }
        }
    }


}
