package cn.didadu.sample.easycoding;

/**
 * @author zhangjing
 * @date 2018/11/6
 */
public class ExceptionTest {
    public static void main(String[] args) {
        System.out.println(finallyNotWork());
    }

    public static int finallyNotWork() {
        int temp = 10000;
        try {
            throw new Exception();
        } catch (Exception e) {
            // 先执行return，再执行finally
            // 执行return语句时，将返回值暂存到局部变量表，最后再入栈Return
            return ++temp;
        } finally {
            temp = 9999;
        }
    }
}
