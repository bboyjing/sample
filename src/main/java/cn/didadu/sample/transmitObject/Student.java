package cn.didadu.sample.transmitObject;

/**
 * 测试是否能修改传递地引用
 * @author zhangjing
 * @date 2019-08-19
 */
public class Student {
    public String name;

    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "bboyjing";

        test(s1);
        System.out.println(s1.name);

        test2(s1);
        System.out.println(s1.name);
    }

    /**
     * 修改s的引用为s2，不会影响到调用方
     * @param s
     */
    public static void test(Student s) {
        Student s2 = new Student();
        s2.name = "zj";
        s = s2;
    }

    /**
     * 直接修改s的属性，会影响到调用方
     * @param s
     */
    public static void test2(Student s) {
        s.name = "zj";
    }
}


