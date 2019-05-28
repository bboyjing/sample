package cn.didadu.sample.hsdis;

/**
 *  在当前目录运行
 *  javac -d ./ MyClass.java  MySon.java （因为类带有package，-d ./ 是在当前文件夹生成完成的包路径）
 *  jdb -XX:+UseSerialGC -Xmx10m -XX:-UseCompressedOops
 *  stop in cn.didadu.sample.hsdis.MySon.add (在add函数上打断点)
 *  run cn.didadu.sample.hsdis.MySon
 *  main[1] > next (next 将进入add函数的第二行代码)
 *
 *  重新开一个终端
 *  jps (找出MySon的进程号)
 *  sudo java -classpath /Library/Java/JavaVirtualMachines/jdk1.8.0_202.jdk/Contents/Home/lib/sa-jdi.jar sun.jvm.hotspot.HSDB
 *  file -> Attach to HotSpot process (连上MySon进程)
 *  windows -> console ，在Command Line中按回车
 *  在Command Line中输入 > universe
 *  在Command Line中输入 > scanoops 0x0000000102a00000 0x0000000103400000 cn.didadu.sample.hsdis.MySon (从开始为到结束位置搜索MySon)
 *  可以使用如下两种方式查看MySon内存信息
 *   1、在Command Line中输入 > inspect 0x0000000102ab00a8 (用inspect查看找到的位置，将会输出MySon的内存信息)
 *   2、Tools -> Inspector 输入0x0000000102ab00a8 即可以图形化的方式查看MySon的内存信息
 * @author zhangjing
 * @date 2019-04-16
 */
public class MySon extends MyClass{
    private long l;
    private Integer i = 3;
    private long plong = 18L;
    public char c = 'B';

    public void add(int a, int b) {
        MySon mySon = this;
        int z = a + b;
        int x = 3;
    }

    public static void main(String[] args) {
        MySon mySon = new MySon();
        mySon.add(2, 3);
    }

}
