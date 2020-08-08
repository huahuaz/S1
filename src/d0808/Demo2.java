package d0808;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Demo2 {
    public static void main(String[] args) {
        //Set 集合：无序 不重复
        Set<String> set = new HashSet<>();

        set.add("张三");
        set.add("李四");
        set.add("王五");
        set.add("南派三叔");

        set.add("吴邪");
        set.add("张起灵");

        //set 没有get 方法，但是可以使用增强for循环
        for (String name : set) {
            System.out.print(name + " ");
        }
        System.out.println();
        System.out.println(set);

        //set 的迭代器循环(list也可以用)
        //所有的集合都是实现迭代器接口
        //该接口可以用于集合变量的所有元素
        Iterator<String> it = set.iterator();
        //while 循环的迭代器写法
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        //for循环的迭代器写法
        for (Iterator<String> it1 = set.iterator(); it1.hasNext(); ) {
            System.out.println(it1.next());
        }
    }
}
