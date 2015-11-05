package cn.didadu.sample.zookeeper.chapter05.$5_3_6;
import java.util.concurrent.CountDownLatch;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

// ZooKeeper API 删除节点，使用同步(sync)接口。
public class Exist_API_Sync_Usage implements Watcher {

    private static CountDownLatch connectedSemaphore = new CountDownLatch(1);
    private static ZooKeeper zk;
    public static void main(String[] args) throws Exception {

    	String path = "/zk-book";
    	zk = new ZooKeeper("domain1.book.zookeeper:2181", 
				5000, //
				new Exist_API_Sync_Usage());
    	connectedSemaphore.await();

        /**
         * 通过exists接口检测是否存在指定节点，同事注册一个Watcher
         */
    	zk.exists( path, true );

        /**
         * 创建节点/zk-book，服务器会向客户端发送事件通知：NodeCreated
         * 客户端收到通知后，继续调用exists接口，注册Watcher
         */
    	zk.create( path, "".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT );

        /**
         * 更新节点数据，服务器会向客户端发送事件通知：NodeDataChanged
         * 客户端收到通知后，继续调用exists接口，注册Watcher
         */
    	zk.setData( path, "123".getBytes(), -1 );

        /**
         * 创建子节点
         */
    	zk.create( path+"/c1", "".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT );

        /**
         * 删除子节点
         */
    	zk.delete( path+"/c1", -1 );

        /**
         * 删除节点/zk-book
         * 客户端会收到服务端的事件通知：NodeDeleted
         */
    	zk.delete( path, -1 );
    	
        Thread.sleep( Integer.MAX_VALUE );
    }

    @Override
    public void process(WatchedEvent event) {
        try {
            if (KeeperState.SyncConnected == event.getState()) {
                if (EventType.None == event.getType() && null == event.getPath()) {
                    connectedSemaphore.countDown();
                } else if (EventType.NodeCreated == event.getType()) {
                    System.out.println("Node(" + event.getPath() + ")Created");
                    zk.exists( event.getPath(), true );
                } else if (EventType.NodeDeleted == event.getType()) {
                    System.out.println("Node(" + event.getPath() + ")Deleted");
                    zk.exists( event.getPath(), true );
                } else if (EventType.NodeDataChanged == event.getType()) {
                    System.out.println("Node(" + event.getPath() + ")DataChanged");
                    zk.exists( event.getPath(), true );
                }
            }
        } catch (Exception e) {}
    }
}