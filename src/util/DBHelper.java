package util;

import java.io.IOException;

public class DBHelper {
    public static void close(AutoCloseable... closers) {
        //closers 是一个数组 类型是Closeable[]
        for (AutoCloseable closer : closers) {
            if (closer != null) {
                try {
                    closer.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
