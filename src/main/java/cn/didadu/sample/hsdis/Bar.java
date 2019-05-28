package cn.didadu.sample.hsdis;

/**
 * HSDIS文件位于：/Library/Java/JavaVirtualMachines/jdk-11.0.2.jdk/Contents/Home/lib/hsdis-amd64.dylib
 * javap -verbose
 * @author zhangjing
 * @date 2019-03-20
 */
public class Bar {
    int a=1;
    static int b=2;
    public int sum(int c){
        return a+b+c;
    }

    public static void main(String[] args){
        new Bar().sum(3);
    }
}
