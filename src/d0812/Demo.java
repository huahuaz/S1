package d0812;

public class Demo implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {
        //b();
        try {
            c();
        } catch (MyException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public static void a() {
        int i = 1 / 0;//产生数学异常 ==> java虚拟机产生
    }

    public static void b() {
        try {
            a();//运行期异常
        } catch (Exception e) {
            e.printStackTrace();//打印异常
            throw e;//抛出异常
        }
    }

    /**
     * 编译器异常从方法抛出必须声明
     */
    public static void c() throws MyException {
        //自定义异常不能由虚拟产生
        throw new MyException("这是我定义的异常，没什么业务含义");
    }

    public static void d() throws MyException1 {
        try {
            c();//不处理编译期异常会导致编译错误，继续抛出
        } catch (MyException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 自定义的编译期异常 自动生成异常的代码
 */
class MyException extends Exception {
    private static final long serialVersionUID = 1L;

    public MyException() {
        super();
    }

    public MyException(String message) {
        super(message);
    }

    public MyException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyException(Throwable cause) {
        super(cause);
    }

    protected MyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

/**
 * 自定义的运行期异常 自动生成异常的代码
 */
class MyException1 extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public MyException1() {
        super();
    }

    public MyException1(String message) {
        super(message);
    }

    public MyException1(String message, Throwable cause) {
        super(message, cause);
    }

    public MyException1(Throwable cause) {
        super(cause);
    }

    protected MyException1(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
