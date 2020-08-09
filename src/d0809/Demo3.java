package d0809;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Demo3 {
    public static void main(String[] args) throws IOException {
        /**
         * 输出:程序 ==> 文件(程序外
         * 输入:文件(程序外) ==>程序
         *
         * 流的分类和命名:
         * 出入方向分:
         *     输入流:Input or Reader
         *     输出流:Output or Writer
         * 读写数据的格式分:
         *     字节流:类名中带Stream
         *        jpg,gif,MP3,avi 二进制数据0,1
         *        以字节单位读写文件
         *     字符流:类名中带Reader or Writer
         *        txt,xml,html 文字信息
         *        以字符为单位读写文件
         * 处理的对象
         *     资源流:读文件，读内存，读网络，流对象在构建时会传入被处理的资源名(例如:文件)
         *     处理流:处理另外一个流的数据，流对象在构建时会传入另外一个流
         */

        //将hel1o world写入文件
        // 1. 操作的是字符还是字节: Reader或Writer或Stream ==> Reader 或Writer
        //2.出入方向:Reader 或Writer 或Input 或Output ==> Writer
        //目的是什么: File  ==> FileWriter
        FileWriter fw = null;
        try {
            //创建流
            fw = new FileWriter("d:/temp/a.txt");
            //输出字符
            fw.append("hello world");
            //Thread.sleep(1000 * 60);
        } catch (IOException e) {
            //读写文件产生的异常
            e.printStackTrace();
        }/* catch (InterruptedException e) {
            //休眠产生异常
            e.printStackTrace();
        }*/ finally {
            //流用完之后必须关闭，
            //如果不关闭，那么该文件会一直处于被打开的状态，那么其他程序将无法操作该文件
            fw.close();
        }

        //读取文件
        FileReader fr = null;
        try {
            fr = new FileReader("d:/temp/a.txt");
            //读入的字符数组
            char[] buffer = new char[1024];
            //count 存放读入的字符数
            int count = fr.read(buffer);
            String text = new String(buffer, 0, count);
            System.out.println(text);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
