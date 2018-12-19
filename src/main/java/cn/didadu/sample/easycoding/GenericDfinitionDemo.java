package cn.didadu.sample.easycoding;

/**
 * @author zhangjing
 * @date 2018/11/1
 */
public class GenericDfinitionDemo<T> {
    // 如下String 并非是java.lang.String类型，而是泛型标识<String>
    static <String, T, Alibaba> String get(String string, Alibaba alibaba) {
        return string;
    }

    public static void main(String[] args) {
        Integer first = 222;
        Long second = 333L;
        Integer result = get(first, second);
        System.out.println(result);
    }
}
