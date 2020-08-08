package d0805;

public class Demo1 {
    public static void main(String[] args) {
        a();
        b();
        c(null);
    }

    public static void a() {
        try {
            System.out.println("=====a=====");
            int[] a = {1, 2, 3};
            System.out.println(a[0]);
            System.out.println(a[1]);
            System.out.println(a[2]);
            //数据越界
            System.out.println(a[4]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("异常信息" + e.getMessage());//获取异常的信息
            //获取异常原因异常，一个异常导致另一个异常
            //那么该异常就是另一个异常原因异常
            System.out.println("原因异常" + e.getCause());
            //打印异常的方法调用栈
            e.printStackTrace();
            System.out.println("访问的数组元素不存在!");
        }
    }

    public static void b() {
        try {
            System.out.println("=====b=====");
            //除0异常
            int a = 1 / 0;
        } catch (ArithmeticException e) {
            System.out.println("除0异常!");
        }

    }

    public static void c(Object obj) {
        try {
            System.out.println("=====c=====");
            System.out.println(obj);
            //输出obj对象哈希码这里会出现大名鼎鼎的空指针异常
            System.out.println(obj.hashCode());
        } catch (NullPointerException e) {
            System.out.println("空指针异常!");
        }
    }
}