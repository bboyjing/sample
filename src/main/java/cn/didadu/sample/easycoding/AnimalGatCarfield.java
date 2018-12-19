package cn.didadu.sample.easycoding;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangjing
 * @date 2018/11/27
 * 用动物的猫科与加菲猫的集成关系说明extend与super在集合中的意义
 */
public class AnimalGatCarfield {
    public static void main(String[] args) {
        // 第一段：声明三个一次继承的类的集合：Object>动物>猫>加菲猫
        List<Animal> animal = new ArrayList<>();
        List<Cat> cat = new ArrayList<>();
        List<Garfield> garfield = new ArrayList<>();
        animal.add(new Animal());
        cat.add(new Cat());
        garfield.add(new Garfield());

        // 第二段：测试赋值操作
        // 下行编译出错，只能赋值Cat或Cat子类的集合
        // List<? extends Cat> extendsCatFromAnimal = animal;
        List<? super Cat> superCatFromAnimal = animal;
        List<? extends Cat> extendsCatFromCat = cat;
        List<? super Cat> superCatFromCat = cat;
        List<? extends Cat> extendsCatFromGarfield = garfield;
        // 下行编译出错，只能赋值Cat或Cat父类的集合
        // List<? super Cat> superCatFromGarfield = garfield;

        // 第三段：测试add方法
        // Java把泛型检查放到了编译期，? extends的集合中不允许添加元素
//        extendsCatFromCat.add(new Animal());
//        extendsCatFromCat.add(new Cat());
//        extendsCatFromCat.add(new Garfield());

        // 下行编译出错，只能添加Cat或Cat子类的集合
        // superCatFromCat.add(new Animal());
        superCatFromCat.add(new Cat());
        superCatFromCat.add(new Garfield());

        // 第四段：测试get方法
        // 所有super操作能够返回元素。但是泛型丢失，只能返回object对象
        Object catExtends2 = extendsCatFromCat.get(0);
        Cat catExtends1 = extendsCatFromCat.get(0);
        // 下行编译出错，虽然Cat集合从Garfield赋值而来，单类型擦出后，是不知道的
        // Garfield garfield1 = extendsCatFromGarfield.get(0);
    }

}

class Animal {

}

class Cat extends Animal {

}

class Garfield extends  Cat {

}
