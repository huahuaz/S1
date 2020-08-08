package d0806.hw;

import java.io.UnsupportedEncodingException;

/**
 * 字符串练习
 * 请参考API: http://www.matools.com/api/java8
 */
public class ExerciseString1 {
    public static void main(String[] args) {
        ExerciseString1 e = new ExerciseString1();
        e.testString();
    }

    public void testString() {
        /**
         * 构造方法
         */
        // String(String original) 初始化新创建的String对象，使其表示与参数相同的字符序列;
        String a = new String("abc");
        System.out.println(a);
        //							换句话说，新创建的字符串是参数字符串的副本。

        // String(char[] value)	分配一个新的 String ，以便它表示当前包含在字符数组参数中的字符序列。
        char[] chars = {'a', 'b', 'c', 'f', 'm', 'j'};
        String b = new String(chars);
        System.out.println(b);

        // String(char[] value, int offset, int count) 分配一个新的 String ，其中包含字符数组参数的子阵列中的字符。
        String str2 = String.copyValueOf(chars, 2, 3);
        System.out.println(str2);
        // String(byte[] bytes) 通过使用平台的默认字符集解码指定的字节数组来构造新的 String 。
        byte[] bytes = {100, 99, 98};
        String c = new String(bytes);
        System.out.println(c);

        // String(byte[] bytes, Charset charset) 构造一个新的String由指定用指定的字节的数组解码charset 。
        String d = "世界";
        byte[] bytes1 = null;
        try {
            bytes1 = d.getBytes("GBK");
            String res = new String(bytes1, "GBK");
            System.out.println(res);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        /**
         * 实例方法
         */
        // 执行 ???At(int index) 返回 char指定索引处的值。
        String s = "abcdefghijklmnyimccde";
        System.out.println(s.charAt(2));

        // 执行 ???To(String anotherString) 按字典顺序比较两个字符串。
        String z = "a";
        System.out.println(z.compareTo("d"));

        // 执行 con???(String str) 将指定的字符串连接到该字符串的末尾。
        System.out.println(s.concat("c"));
        // 执行 con???(CharSequence s) 当且仅当此字符串包含指定的char值序列时才返回true。
        System.out.println(s.contains("j"));
        // 执行 ???With(String suffix) 测试此字符串是否以指定的后缀结尾。
        System.out.println(s.endsWith("de"));
        System.out.println(s.endsWith("mn"));
        // 执行 equals???(String anotherString) 将此 String与其他 String比较，忽略案例注意事项。( 忽略大小写 )
        System.out.println(z.equalsIgnoreCase("a"));
        // 执行 get???() 使用平台的默认字符集将此 String编码为字节序列，将结果存储到新的字节数组中。
        String s1 = "Hello";
        byte[] b1 = s1.getBytes();
        for (int i = 0; i < b1.length; i++) {
            System.out.println("index" + i + "is:" + b1[i]);
        }
        // 执行 ???Of(int ch) 返回指定字符第一次出现的字符串内的索引。
        System.out.println(s.indexOf("l"));
        // 执行 ???Of(int ch, int fromIndex) 返回指定字符第一次出现的字符串内的索引，以指定的索引开始搜索。
        System.out.println(s.indexOf("m", 0));
        // 执行 ???Of(String str) 返回指定子字符串第一次出现的字符串内的索引。
        System.out.println("msjfbdchsas".indexOf("j"));
        // 执行 ???Of(String str, int fromIndex) 返回指定子串的第一次出现的字符串中的索引，从指定的索引开始。
        System.out.println("sdnsajifba".indexOf("a", 5));
        // 执行 is???() 返回 true如果，且仅当 length()为 0 。
        String s2 = new String();
        System.out.println(s2.isEmpty());
        // 执行 ???Of(int ch) 返回指定字符的最后一次出现的字符串中的索引。
        System.out.println("sajdnxjasf".lastIndexOf(97));
        // 执行 ???Of(String str) 返回指定子字符串最后一次出现的字符串中的索引。
        System.out.println("sajdnxjasf".lastIndexOf("nxj"));
        // 执行 len???() 返回此字符串的长度。
        System.out.println(s.length());
        // 执行 replace???(String regex, String replacement)
        //				用给定的替换替换与给定的 regular expression匹配的此字符串的每个子字符串。
        String s3 = new String("addfxcvz");
        System.out.println(s3.replaceAll("d", "g"));
        // 执行 replace???(String regex, String replacement)
        //				用给定的替换替换与给定的 regular expression匹配的此字符串的第一个子字符串。
        System.out.println(s3.replace("ad", "l"));
        // 执行 sp???(String regex) 将此字符串分割为给定的 regular expression的匹配。
        String[] result = "this is a test".split("s");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
        }
        System.out.println();

        // 执行 ???With(String prefix) 测试此字符串是否以指定的前缀开头。
        System.out.println("shdas".startsWith("a"));
        // 执行 ???string(int beginIndex)(String prefix) 返回一个字符串，该字符串是此字符串的子字符串。
        System.out.println("shdcjx".substring(3));
        // 执行 ???string(int beginIndex, int endIndex) 返回一个字符串，该字符串是此字符串的子字符串。
        System.out.println(s.substring(1, 6));
        // 执行 to???() 将此字符串转换为新的字符数组。
        char[] c1 = "toCharArray".toCharArray();
        for (int i = 0; i < c1.length; i++) {
            System.out.print(c1[i]);
        }
        System.out.println();
        // 执行 to???() 将所有在此字符 String使用默认语言环境的规则，以小写。( 转小写 )
        System.out.println("ACHXZHS".toLowerCase());
        // 执行 tr???() 将所有在此字符 String使用默认语言环境的规则大写。( 转大写 )
        System.out.println("asjcbx".toUpperCase());
        // 执行 to???() 返回一个字符串，其值为此字符串，并删除任何前导和尾随空格。
        System.out.println("   sfsdweh".trim());
        /**
         * 静态方法
         */
        // 执行 for???(String format, Object... args) 使用指定的格式字符串和参数返回格式化的字符串。
        System.out.println(String.format("%x", 57));
    }
}
