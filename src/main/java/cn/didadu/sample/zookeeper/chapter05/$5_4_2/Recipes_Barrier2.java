package cn.didadu.sample.zookeeper.chapter05.$5_4_2;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.barriers.DistributedDoubleBarrier;
import org.apache.curator.retry.ExponentialBackoffRetry;
public class Recipes_Barrier2 {
	static String barrier_path = "/curator_recipes_barrier_path";
	public static void main(String[] args) throws Exception {
		
		for (int i = 0; i < 5; i++) {
			new Thread(() -> {
				try {
					CuratorFramework client = CuratorFrameworkFactory.builder()
							.connectString("domain1.book.zookeeper:2181")
							.retryPolicy(new ExponentialBackoffRetry(1000, 3)).build();
					client.start();
					DistributedDoubleBarrier barrier = new DistributedDoubleBarrier(client, barrier_path,5);
					Thread.sleep( Math.round(Math.random() * 3000) );

					/**
					 * enter方法进入等待
					 */
					System.out.println(Thread.currentThread().getName() + "号进入barrier" );
					barrier.enter();

					/**
					 * 当等待进入的成员达到预期数量后，同时启动
					 */
					System.out.println("启动...");
					Thread.sleep( Math.round(Math.random() * 3000) );

					/**
					 * leave再次同时进入等待退出状态
					 */
					barrier.leave();

					/**
					 * 当等待进入的成员达到预期数量后，同时退出
					 */
					System.out.println( "退出..." );
				} catch (Exception e) {}
			}).start();
		}
	}
}