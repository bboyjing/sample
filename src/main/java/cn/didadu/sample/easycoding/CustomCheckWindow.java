package cn.didadu.sample.easycoding;

import java.util.concurrent.Semaphore;

/**
 * @author zhangjing
 * @date 2018/12/17
 */
public class CustomCheckWindow {
    public static void main(String[] args) {
        // 设定三个信号量，即3个服务窗口
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i <=5; i++) {
            new SecurityCheckThread(i, semaphore).start();
        }
    }

    private static class SecurityCheckThread extends Thread{
        private int seq;
        private Semaphore semaphore;

        public SecurityCheckThread(int seq, Semaphore semaphore) {
            this.seq = seq;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("No." + seq + "乘客，正在查验中");

                // 假设号码是整出2的人事身份可以人员，需要花更长的时间来安检
                if (seq % 2 == 0) {
                    Thread.sleep(1000);
                    System.out.println("No." + seq + "乘客，身份可疑，不能出国！");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
                System.out.println("No." + seq + "乘客已经完成服务");
            }
        }
    }

}


