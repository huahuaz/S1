package d0806;

public class Demo2 {
    public static void main(String[] args) {
        //String ==> 存放数据的王者
        String a = "abc";//自勉之==> 对象 : 装箱
        a = "123";
        System.out.println(a);

        a = new String();//空字符串 0字节
        System.out.println(a);
        a = new String("efg");//标准写法
        System.out.println(a);

        char[] cs = {'x', 'y', 'z'};
        a = new String(cs);
        System.out.println(a);

        byte[] bs = {98, 99, 97};
        a = new String(bs);
        System.out.println(a);

        a = "123456789";
        System.out.println("判断是否包含:" + a.contains("456"));
        System.out.println("判断是否包含:" + a.indexOf("456"));
        System.out.println("判断是否包含:" + a.indexOf("654"));

        //必须写 a=
        a.replace("456", "你好");
        System.out.println(a);
        a = a.replace("456", "你好");
        System.out.println(a);

        System.out.println(a.length());

        System.out.println("=====String 比较======");
        //String 比较和连接
        String b = "123";
        String c = "321";
        System.out.println(b == c);//false
        c = "123";
        System.out.println(b == c);//true
        c = new String("123");
        System.out.println(b == c);//false
        System.out.println(b.equals(c));//true

        //忽略大小写的字串符比较
        b = "abc";
        c = "ABC";
        System.out.println(b.equals(c));//false
        System.out.println(b.equalsIgnoreCase(c));//true

        /**
         * 1. == 在对比引用数据类型时，比较的是对象的地址
         *   a="123"
         *   c = new String("123");//新的对象123新的地址
         * 2.java对字符串的值进行了缓存
         *  a ==> "123" ==> new String("123");
         *  c ==> "123" ==> 从字符串池中找出一个123赋值给c;
         *  a==c ==> true
         *
         *  那么如何比较两个两个字符串的内容呢？
         *  使用equals ==> equals是 Object 类的方法
         *  String 对equals进行了重写
         */

        System.out.println("=====String 连接======");
        b = "你好" + "世界";
        long stime = System.currentTimeMillis();//获取当前时间
        for (int i = 0; i < 50000; i++) {
            b += "世界";
        }
        long etime = System.currentTimeMillis();
        System.out.println("b=" + b);
        System.out.println((etime - stime) / 1000 + "秒");

        //String 的不变性导致大量的连接操作，会严重降低性能
        //StringBuffer(线程安全),StringBuilder(线程不安全，性能更高)
        //StringBuffer,StringBuilder 不支持+号 连接
        StringBuilder sb = new StringBuilder();
        stime = System.currentTimeMillis();//获取当前时间
        for (int i = 0; i < 20000; i++) {
            sb.append("世界");
        }
        System.out.println("sb=" + sb);
        etime = System.currentTimeMillis();
        System.out.println((etime - stime) / 1000 + "秒");
    }
}
