package d0805;

public class Demo2 {

    public static void main(String[] args) {
        try {
            System.out.println("开始执行!");
            a();
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("空指针异常，执行出错!");
        } catch (ArithmeticException e) {
            //异常被捕获到，一般都要打印方法栈
            e.printStackTrace();
            System.out.println("除0异常，执行出错!");
        } catch (RuntimeException e) {
            //异常被捕获到，一般都要打印方法栈
            e.printStackTrace();
            System.out.println("运行时异常，执行出错!");
        } finally {
            //时表示：不管有没有出现错误，finally都一定会执行
            System.out.println("执行结束!");
        }
    }

    public static void test1() {
        try {
            System.out.println("开始执行!");
            a();
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("空指针异常，执行出错!");
        } catch (ArithmeticException e) {
            //异常被捕获到，一般都要打印方法栈
            e.printStackTrace();
            System.out.println("除0异常，执行出错!");
        } finally {
            //时表示：不管有没有出现错误，finally都一定会执行
            System.out.println("执行结束!");
        }
    }

    public static void a() {
        System.out.println("=====a======");
        b();
        int[] a = {};
        System.out.println(a[0]);
    }

    public static void b() {
        System.out.println("=====b======");
        c();
        int i = 1 / 1;
    }

    public static void c() {
        System.out.println("=====c======");
        Object o = new Object();
        o.toString();
    }
}
