package cn.didadu.sample.hsdis;

import net.sf.ehcache.pool.sizeof.AgentSizeOf;
import net.sf.ehcache.pool.sizeof.SizeOf;
import net.sf.ehcache.pool.sizeof.UnsafeSizeOf;

import java.lang.reflect.Field;

/**
 * add to VM options：-XX:+PrintCommandLineFlags
 * @author zhangjing
 * @date 2019-04-15
 */
public class Father {
    private byte a;
    private byte b;
    private byte c;
    private byte d;
    private byte e;

    public Father() {
        this.a = 1;
        this.b = 2;
    }

    public byte getA() {
        return a;
    }

    public void setA(byte a) {
        this.a = a;
    }

    public byte getB() {
        return b;
    }

    public void setB(byte b) {
        this.b = b;
    }

    public static void main(String[] args) {
        // AgentSizeOf报错，用UnsafeSizeOf替代
        // SizeOf sizeOf = new AgentSizeOf();
        SizeOf sizeOf = new UnsafeSizeOf();
        Father father = new Father();
        System.out.println(sizeOf.sizeOf(father));

        Field[] fields = Father.class.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }
    }
}
