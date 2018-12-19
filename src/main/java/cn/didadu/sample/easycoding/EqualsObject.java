package cn.didadu.sample.easycoding;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhangjing
 * @date 2018/11/28
 */
public class EqualsObject {
    private int id;
    private String name;

    public EqualsObject(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        // 如果为null， 或者并非同类，则直接返回false
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        // 如果引用指向同一个对象，则返回true
        if (this == obj) {
            return true;
        }

        // 需要强制转换来获取EqualsObject的方法
        EqualsObject temp = (EqualsObject) obj;
        // 本示例判断标准是两个属性值相等，逻辑随业务场景不通而不同
        if (temp.getId() == this.getId() && temp.getName().equals(this.getName())) {
            return true;
        }

        return false;
    }

//    @Override
//    public int hashCode() {
//        return  this.id + this.name.hashCode();
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        // EqualsObject没有覆写hashcode，把这个对象放到Set集合中去
        Set<EqualsObject> hashSet = new HashSet<>();
        EqualsObject a = new EqualsObject(1, "one");
        EqualsObject b = new EqualsObject(1, "one");
        EqualsObject c = new EqualsObject(1, "one");
        hashSet.add(a);
        hashSet.add(b);
        hashSet.add(c);
        // 因为没有覆写hashcode，size为3
        System.out.println(hashSet.size());
    }
}
