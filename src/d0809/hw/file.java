package d0809.hw;

import util.IOHelper;

import java.io.*;
import java.util.Scanner;

/**
 * 1、在控制台输出 D:\ 目录下所有文件和目录
 * 2、创建文件夹 myfiles
 * 3、在 myfiles 文件夹中创建以下文件。注意，如果文件已经存在，需要提示用户该文件已经存在：
 * readme.txt
 * info.txt
 * test.ini
 * tools.txt
 * students.ini
 * baidu.inf
 * taobao.inf
 * helloworld.java
 * head.jpg
 * red.gif
 * green.bmp
 * 4、过滤查询所有的 txt 文件 ( 参考 listFiles(FileFilter filter) 方法 )
 * 5、修改所有的图片文件，将文件名前面加入“图片_”
 * 6、删除所有以字母 t 开头文件
 * 7、在 readme.txt 文件中，使用流写入一首唐诗
 * 8、使用流将 readme.txt 的内容读取出来, 并输出到控制台上
 */

public class file {
    private static File dir = new File("f:/myfiles");
    private static String[] wj = new String[]{"readme.txt", "info.txt", "test.ini", "tools.txt", "students.ini",
            "baidu.inf", "taobao.inf", "helloworld.java", "head.jpg", "red.gif", "green.bmp"};
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        file.Menu();
        /*if (!dir.exists()) {
            dir.mkdir();
        } else {
            System.out.println(dir.getName() + "文件夹已存在");
        }*/
        //System.out.println("=======1=========");
        //fi.FileD();
        /*for (int i = 0; i < wj.length; i++) {
            files(wj[i]);
        }*/
        /*System.out.println("过滤查询txt文件:");
        file.Text();
        System.out.println("修改图片文件名:");*/
        /*file.changeTu("图片");
        file.quaryTu();*/
        /*try {
            for (int i = 0; i < wj.length; i++) {
                if (wj[i].substring(0, 1).equals("t")) {
                    delFolfer(wj[i]);
                }
            }
            System.out.println("删除成功!");
        } catch (Exception e) {
            System.out.println("文件删除出错!");
        }*/
    }

    public static void Menu() {
        while (true) {
            System.out.println("1、在控制台输出 D:\\ 目录下所有文件和目录\n" +
                    "2、创建文件夹 myfiles\n" +
                    "3、在 myfiles 文件夹中创建以下文件。注意，如果文件已经存在，需要提示用户该文件已经存在：\n" +
                    "\treadme.txt\n" +
                    "\tinfo.txt\n" +
                    "\ttest.ini\n" +
                    "\ttools.txt\n" +
                    "\tstudents.ini\n" +
                    "\tbaidu.inf\n" +
                    "\ttaobao.inf\n" +
                    "\thelloworld.java\n" +
                    "\thead.jpg\n" +
                    "\tred.gif\n" +
                    "\tgreen.bmp\n" +
                    "4、过滤查询所有的 txt 文件 ( 参考 listFiles(FileFilter filter) 方法 )\n" +
                    "5、修改所有的图片文件，将文件名前面加入“图片_”\n" +
                    "6、删除所有以字母 t 开头文件\n" +
                    "7、在 readme.txt 文件中，使用流写入一首唐诗\n" +
                    "8、使用流将 readme.txt 的内容读取出来, 并输出到控制台上");
            int put = sc.nextInt();
            switch (put) {
                case 1:
                    file.FileD();
                    break;
                case 2:
                    if (!dir.exists()) {
                        dir.mkdir();
                    } else {
                        System.out.println(dir.getName() + "文件夹已存在");
                    }
                    break;
                case 3:
                    for (int i = 0; i < wj.length; i++) {
                        files(wj[i]);
                    }
                    break;
                case 4:
                    System.out.println("过滤查询txt文件:");
                    file.Text();
                case 5:
                    System.out.println("修改图片文件名:");
                    file.changeTu("图片");
                    file.quaryTu();
                    break;
                case 6:
                    try {
                        for (int i = 0; i < wj.length; i++) {
                            if (wj[i].substring(0, 1).equals("t")) {
                                delFolfer(wj[i]);
                            }
                        }
                        System.out.println("删除成功!");
                    } catch (Exception e) {
                        System.out.println("文件删除出错!");
                    }
                    break;
                case 7:
                    file.write();
                    break;
                case 8:
                    file.load();
                    break;
            }
        }
    }

    /**
     * 遍历D盘文件
     */
    public static void FileD() {
        File f = new File("d:\\");
        boolean b = false;

        file.filelist(f);
    }

    public static void filelist(File file) {
        File[] files = file.listFiles();
        if (files != null) {
            for (File fl : files) {
                System.out.println(fl.getAbsolutePath());
                filelist(fl);
            }
        }
    }

    /**
     * 创建文件
     */
    public static void files(String name) {
        File file = new File(dir, name);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("创建文件出错了!");
                e.printStackTrace();
            }
        } else {
            System.out.println(file.getName() + "文件已存在");
        }
    }

    /**
     * 删除文件夹
     */
    public static void delFolfer(String name) {
        try {
            File file = new File(dir, name);
            file.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 过滤txt文件
     */
    public static void Text() {
        FilenameFilter filter = new TxtFilenameFileter();
        String[] files = dir.list(filter);
        for (String filename : files) {
            System.out.println(filename);
        }
    }

    static class TxtFilenameFileter implements FilenameFilter {
        public boolean accept(File dir, String name) {
            boolean ret = name.endsWith("txt");
            return ret;
        }
    }

    /**
     * 修改图片文件名
     */
    public static void changeTu(String name) {
        FilenameFilter filter = new TuFilenameFilter();
        String[] tuFiles = dir.list(filter);
        File[] file = new File[tuFiles.length];
        String[] files = new String[tuFiles.length];
        for (int i = 0; i < tuFiles.length; i++) {
            file[i] = new File(dir, tuFiles[i]);
            files[i] = file[i].getAbsolutePath();
        }
        for (int i = 0; i < files.length; i++) {
            testRenameFile(files[i], name);
        }
    }

    //查询图片文件
    public static void quaryTu() {
        FilenameFilter filter = new TuFilenameFilter();
        String[] files = dir.list(filter);
        for (String filename : files) {
            System.out.println(filename);
        }
    }

    /**
     * 过滤图片文件
     */
    static class TuFilenameFilter implements FilenameFilter {
        public boolean accept(File dir, String name) {
            return name.endsWith("jpg") || name.endsWith("gif") || name.endsWith("bmp");
        }
    }

    /**
     * 重命名一个文件：将原来的文件直接修改
     *
     * @param filePath 文件路径
     * @param name     要加文件名
     */
    private static void testRenameFile(String filePath, String name) {

        int a = filePath.lastIndexOf("s");
        try {
            File src = new File(filePath);
            StringBuffer stringBuilder1 = new StringBuffer(filePath);
            stringBuilder1.insert(a + 2, name);
            filePath = String.valueOf(stringBuilder1);
            File des = new File(filePath);
            if (des.exists()) {
                boolean res = des.delete();
                if (!res) {
                    System.out.println("删除文件失败");
                }
            }
            if (!src.renameTo(des)) {
                System.out.println("重命名文件失败");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 写入唐诗
     */
    public static void write() {
        FileWriter fw = null;
        try {
            fw = new FileWriter(dir + "/readme.txt");
            fw.write("两人对酌山花开，一杯一杯复一杯 \n" +
                    "我醉欲眠卿且去，明朝有意抱琴来");
        } catch (IOException e) {
            System.out.println("文件写入错误!");
            e.printStackTrace();
        } finally {
            if (fw != null) {
                IOHelper.close(fw);
            }
            System.out.println("文件写入成功!");
        }
    }

    /**
     * 打印readme.txt
     */
    public static void load() {
        //读取文件
        FileReader fr = null;
        try {
            fr = new FileReader(dir + "/readme.txt");
            //读入的字符数组
            char[] buffer = new char[1024];
            //count 存放读入的字符数
            int count = fr.read(buffer);
            String text = new String(buffer, 0, count);
            System.out.println(text);
        } catch (IOException e) {
            System.out.println("文件读取错误!");
            e.printStackTrace();
        } finally {
            IOHelper.close(fr);
            System.out.println("文件读取成功!");
        }
    }
}
