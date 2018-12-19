package cn.didadu.sample.genericity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangjing
 * @date 2018/5/15
 */

class Fruit { }

class Apple extends Fruit { }

class Orange extends Fruit { }

class RedFujiApple extends Apple { }

/**
 * Java数组支持协变
 * Java数组不支持逆变
 */
public class CovariantArrays {
    public static void main(String[] args) {
        Fruit[] fruits = new Apple[10];
        fruits[0] = new Apple();
        fruits[1] = new RedFujiApple();

        try {
            // java.lang.ArrayStoreException
            fruits[0] = new Fruit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            // java.lang.ArrayStoreException
            fruits[0] = new Orange();
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*
        编译不通过
        泛型是不变的
         */
        //List<Fruit> list = new ArrayList<Apple>();

        /*
        extends指出了泛型的上界为Fruit，<? extends T>称为子类通配符
        通配符看似可是实现协变
        但是List<? extends Fruit>也可以合法的指向一个List<Orange>，显然是错误的
        泛型把类型检查移到了编译期，协变过程丢掉了类型信息，编译器拒绝所有不安全的操作
         */
        List<? extends Fruit> flist = new ArrayList<Apple>();
        //flist.add(new Apple());
        //flist.add(new Fruit());
        //flist.add(new Object());

        // writeTo方法的参数下限为Apple
        // 限制了该方法写入的值的必须Apple或者Apple的子类
        List<Fruit> testWrite = new ArrayList<>();
        CovariantArrays.writeTo(testWrite);

        // readFrom方法的参数上限为Apple
        // 读取的时候申明超类引用是安全的
        List<RedFujiApple> testRead = new ArrayList<>();
        CovariantArrays.readFrom(testRead);
    }

    /**
     * 逆变
     * super指出泛型的下界为Apple，<？ super T>称为超类通配符
     * 限制add方法传入的类型必须是Apple及其子类型
     * super是限制数据流入的（消费者）
     * @param apples
     */
    static void writeTo(List<? super Apple> apples) {
        apples.add(new Apple());
        apples.add(new RedFujiApple());
        /*
        编译不通过
         */
        //apples.add(new Fruit());
    }

    /**
     * <? extends Apple>限制了get方法返回的类型必须是Apple及其父类型
     * extends是限制数据来源的（生产者）
     * @param apples
     */
    static void readFrom(List<? extends Apple> apples)  {
        Apple apple = apples.get(0);
        // 编译不通过
        //RedFujiApple redFujiApple = apples.get(0);
        Fruit fruit = apples.get(0);
    }
}
