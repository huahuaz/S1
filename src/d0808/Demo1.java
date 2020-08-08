package d0808;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Demo1 {
    public static void main(String[] args) {
        //只要是List 下面的类，他们可以完全替代
        //ArrayList 内部使用数组存放元素，查询快，插入慢 线程不安全 速度快
        //List l1 = new ArrayList();
        //LinkedList 内部使用链表存放元素 查询慢，插入块
        //List l1 = new LinkedList();
        //内部使用数组存放元素 线程安全 多线程 速度慢
        List<Integer> l1 = new Vector();
        //泛型告警，所有的集合都是泛型类
        //泛型：对集合存放元素的约束

        l1.add(5);
        l1.add(10);
        l1.add(10);

        System.out.println(l1);//集合可以直接打印

        l1.add(1, 8);
        System.out.println(l1);

        //l1.remove(10);//传 int 类型 ，是根据索引值删除，输入的值被认为是索引
        l1.remove(Integer.valueOf(10));//要删除10这个数字，必须将10转成Integer(对象)
        System.out.println(l1);

        //查找
        System.out.println(l1.indexOf(8));
        //获取集合长度
        System.out.println(l1.size());
        for (int i = 0; i < l1.size(); i++) {
            System.out.print(l1.get(i) + " ");
        }
        System.out.println();
        //一次性清空所有元素
        l1.clear();
        System.out.println(l1.isEmpty());
    }
}
