package cn.didadu.sample.zookeeper.chapter05.$5_4_2;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.barriers.DistributedBarrier;
import org.apache.curator.retry.ExponentialBackoffRetry;

//使用Curator实现分布式Barrier
public class Recipes_Barrier {
    static String barrier_path = "/curator_recipes_barrier_path";
    static DistributedBarrier barrier;

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    CuratorFramework client = CuratorFrameworkFactory.builder()
                            .connectString("domain1.book.zookeeper:2181")
                            .retryPolicy(new ExponentialBackoffRetry(1000, 3)).build();
                    client.start();
                    barrier = new DistributedBarrier(client, barrier_path);
                    System.out.println(Thread.currentThread().getName() + "号barrier设置");

                    /**
                     * 完成barrier设置
                     */
                    barrier.setBarrier();

                    /**
                     * 等待barrier的释放
                     */
                    barrier.waitOnBarrier();

                    System.err.println("启动...");
                } catch (Exception e) {
                }
            }).start();
        }
        Thread.sleep(2000);

        /**
         * 主线程中调用removeBarrier方法来释放barrier
         * 触发所有等待改barrier得子线程同时进行各自的业务逻辑
         */
        barrier.removeBarrier();
    }
}