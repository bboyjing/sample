package cn.didadu.sample.zookeeper.chapter05.$5_4_1;

import java.util.List;

import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.ZkClient;

// ZkClient获取子节点列表。
public class Get_Children_Sample {

    public static void main(String[] args) throws Exception {

    	String path = "/zk-book";
        ZkClient zkClient = new ZkClient("domain1.book.zookeeper:2181", 5000);

        /**
         * 注册回调接口
         */
   /*     zkClient.subscribeChildChanges(path, new IZkChildListener() {
            public void handleChildChange(String parentPath, List<String> currentChilds) throws Exception {
                System.out.println(parentPath + " 's child changed, currentChilds:" + currentChilds);
            }
        });*/

        /**
         * 注册回调接口 lambda写法
         * Listener不是一次性的，注册一次就会一直生效
         */
        zkClient.subscribeChildChanges(path, (parentPath,currentChilds) -> {
            System.out.println(parentPath + " 's child changed, currentChilds:" + currentChilds);
        });

        /**
         * 第一次创建当前节点，客户端会收到通知
         */
        zkClient.createPersistent(path);
        Thread.sleep( 1000 );

        /**
         * 创建子节点，客户端会收到通知
         */
        zkClient.createPersistent(path+"/c1");
        Thread.sleep( 1000 );

        /**
         * 删除子节点，客户端会收到通知
         */
        zkClient.delete(path+"/c1");
        Thread.sleep( 1000 );

        /**
         * 删除当前节点，客户端会收到通知
         */
        zkClient.delete(path);

        Thread.sleep( Integer.MAX_VALUE );
    }
}