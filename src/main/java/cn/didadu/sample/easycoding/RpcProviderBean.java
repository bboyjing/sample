package cn.didadu.sample.easycoding;

/**
 * @author zhangjing
 * @date 2018/11/1
 */
public class RpcProviderBean {
    public void init() throws Exception {
        this.initRegister();
        this.publish();
    }

    public void initRegister() {

    }

    public void publish() {
        // 将本地服务信息发送到注册中心
    }
}
