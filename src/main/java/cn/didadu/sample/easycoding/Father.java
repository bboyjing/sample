package cn.didadu.sample.easycoding;

/**
 * @author zhangjing
 * @date 2018/11/1
 */
public class Father {
    protected void doSometing() {
        System.out.println("Father's doSomething");
        // 此处的this指向的是真正的实例，当前为S
        this.doSometing();
    }

    public static void main(String[] args) {
        Father father = new S();
        father.doSometing();
    }
}

class S extends Father {
    @Override
    protected void doSometing() {
        System.out.println("Son's doSomething");
        super.doSometing();
    }
}
