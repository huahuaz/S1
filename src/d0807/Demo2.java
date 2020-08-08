package d0807;

import java.util.Arrays;

public class Demo2 {
    public static void main(String[] args) {
        //Array 数组工具类 : 排序,查找
        int[] arr = {12, 14, 10, 71, 55, 45, 5};
        System.out.println("排序前直接打印:" + arr);
        //[I@1b6d3586
        //数组 类型 内存地址(哈希码) ==> 数组对象的默认的字符串输出
        System.out.println("排列前格式化后打印:" + Arrays.toString(arr));

        //排列前无法查找
        System.out.println("45在:" + Arrays.binarySearch(arr, 45));
        System.out.println("10在:" + Arrays.binarySearch(arr, 10));

        //默认使用升序排序: 小=>大
        Arrays.sort(arr);
        System.out.println("排序后直接打印:" + arr);
        //Arrays.toString 实现数组的格式化转换成功字符串
        System.out.println("排序后格式化后打印:" + Arrays.toString(arr));

        Person[] ps = {
                new Person("b张三", 27),
                new Person("v李四", 30),
                new Person("s阿芳", 18),
                new Person("a呆呆", 36),
        };
        //ClassCastException: d0807.Person
        //类型转换错误 Integer => String
        //cannot be cast to java.lang.Comparable(接口)
        //可以传入任何类型的数组，可不可以排序那就不知道了？
        //传入sort 方法中的数组，其中的元素必须都是Comparable 接口的子类，才能够排序
        Arrays.sort(ps);
        System.out.println(Arrays.toString(ps));

        //binarySearch 可以查找元素
        /**
         * 注意：binarySearch 方法要求传入数组是排序后的数组
         */
        System.out.println("45在:" + Arrays.binarySearch(arr, 45));
        System.out.println("10在:" + Arrays.binarySearch(arr, 10));
    }
}

class Person implements Comparable <Person>{
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    /**
     * 用于将当前对象和传入的对象进行比较
     * 如果比传入的要大 则返回一个大于0的整数
     * 如果比传入的要笑 则返回一个小于0的整数
     * 如果和传入的相等 则返回0
     */
    public int compareTo(Person o) {
        //假设要对年龄排序，那么使用age进行比较
        //升序
        //return this.age - o.age;
        //降序
        //return o.age - this.age;
        //使用姓名排序，直接调用name的compareTo==>String 实现了Comparable接口
        return this.name.compareTo(o.name);
    }
}
