package cn.didadu.sample.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author zhangjing
 * @date 2019-04-01
 */
public class ReflectMethodConstructorDemo {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<?>[] constructors1 = String.class.getDeclaredConstructors();
        System.out.println("String getDeclaredConstructors 清单（数量 = " + constructors1.length + "）：");
        for(Constructor constructor : constructors1) {
            System.out.println(constructor);
        }

        Constructor<?>[] constructors2 = String.class.getConstructors();
        System.out.println("String getConstructors 清单（数量 = " + constructors2.length + "）：");
        for (Constructor c : constructors2) {
            System.out.println(c);
        }

        System.out.println("====================");

        Constructor constructor = String.class.getConstructor(String.class);
        System.out.println(constructor);
        String str = (String) constructor.newInstance("adfa");
        System.out.println(str);
    }
}
