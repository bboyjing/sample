package cn.didadu.sample.thread;

/**
 * @author zhangjing
 * @date 2019-08-13
 */
public class TestRun {

    public static void Thread(){
        new Thread() {
            int i = 0;
            public void run(){
                boolean flg = false;
                while(!flg){
                    try {
                        i++;
                        System.out.println("我是"+i);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    public static void main(String[] args) {
        Thread();
    }
}

