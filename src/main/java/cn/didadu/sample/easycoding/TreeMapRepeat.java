package cn.didadu.sample.easycoding;

import java.util.TreeMap;

/**
 * @author zhangjing
 * @date 2018/12/6
 */
public class TreeMapRepeat {
    public static void main(String[] args) {
        // 如果仅把此处的TreeMap换成HashMap，则size = 1
        TreeMap map = new TreeMap();
        map.put(new Key(), "value one");
        map.put(new Key(), "value two");
        // TreeMap，size=2，因为Key去重规则是根据排序结果
        // HashMap是使用hashCode和equals实现去重的，而TreeMap依靠Comparable或Comparator来实现Key的去重
        System.out.println(map.size());
    }

}

class Key implements Comparable<Key> {
    @Override
    // 返回负的常数，表示此对象永远小于输入的other对象，此处决定TreeMap的size=2
    public int compareTo(Key o) {
        return -1;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }
}
