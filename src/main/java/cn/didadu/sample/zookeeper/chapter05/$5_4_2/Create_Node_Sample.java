package cn.didadu.sample.zookeeper.chapter05.$5_4_2;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

/**
 * 使用Curator创建节点
 * ZooKeeper规定所有非叶子节点必须为持久节点
 * 所以下面的例子创建的c1节点为临时节点，/zk-book节点为永久节点
 */
public class Create_Node_Sample {
    static String path = "/zk-book/c1";
    static CuratorFramework client = CuratorFrameworkFactory.builder()
            .connectString("domain1.book.zookeeper:2181")
            .sessionTimeoutMs(5000)
            .retryPolicy(new ExponentialBackoffRetry(1000, 3))
            .build();

    public static void main(String[] args) throws Exception {
        client.start();
        client.create()
              .creatingParentsIfNeeded()
              .withMode(CreateMode.EPHEMERAL)
              .forPath(path, "init".getBytes());
    }
}