package cn.didadu.sample.reflect;

/**
 * 通过Class.forName获取Class对象
 * @author zhangjing
 * @date 2019-03-29
 */
public class ReflectClassDemo01 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class c1 = Class.forName("cn.didadu.sample.reflect.ReflectClassDemo01");
        System.out.println(c1.getCanonicalName());

        Class c2 = Class.forName("[D");
        System.out.println(c2.getCanonicalName());

        // 如果以一个L开头的描述符，就是类描述符，它后紧跟着类的字符串，然后分号“；”结束
        Class c3 = Class.forName("[[Ljava.lang.String;");
        System.out.println(c3);
    }
}
