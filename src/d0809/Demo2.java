package d0809;

import java.io.File;
import java.io.IOException;

public class Demo2 {
    public static void main(String[] args) throws IOException {
        File file1 = new File("d:/a.txt");
        //window 文件名忽略大小写，linux 大小写敏感
        File file2 = new File("d:/temp", "a.txt");
        File file3 = new File("d:/temp");
        File file4 = new File(file3, "a.txt");
        //File file5 = new File(URI);一般创建网络上的文件

        System.out.println(file1);
        System.out.println(file2);
        System.out.println(file3);
        System.out.println(file4);

        System.out.println(file1.exists());
        System.out.println(file2.exists());
        System.out.println(file3.exists());
        System.out.println(file4.exists());

        /**
         * 创建文件 该方法会抛出一个IOException
         * 该异常必须捕获(编译期异常),操作系统不一定允许你创建文件(权限问题)
         */
        try {
            //创建文件
            file2.createNewFile();
            //创建单级目录
            File file6 = new File("d:/temp/a");
            file6.mkdir();
            //创建多级目录
            File file7 = new File("d:/temp/a/b/c");
            //file7.mkdir();//返回false 创建失败
            file7.mkdirs();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
