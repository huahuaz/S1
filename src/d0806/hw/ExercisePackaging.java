package d0806.hw;

/**
 * 常用 Integer 方法汇总练习
 * 请根据每行注释的描述，执行指定的方法，并输出结果
 * <p>
 * 请参考API: http://www.matools.com/api/java8
 */
public class ExercisePackaging {
    public static void main(String[] args) {
        ExercisePackaging ep = new ExercisePackaging();
        ep.testInteger();
        ep.testCharacter();
        ep.testBoolean();
    }

    /**
     * Integer 类练习
     * 注意：
     * 其他数值类型的包装类（Long、Double...）也具有相同或类似方法，
     * 请童鞋们自行验证。
     */
    public void testInteger() {

        /**
         * 构造方法
         */
        // 请使用 int值 99 作为参数，创建一个 Integer 变量 number1
        Integer n1 = new Integer("99");
        System.out.println(n1);
        // 请使用 字符串 "88" 作为参数，创建一个 Integer 变量 number2
        Integer n2 = new Integer("88");
        System.out.println(n2);

        Integer a = 1;
        int b = a;
        System.out.println(a + "\t" + b);
        /**
         * 实例方法（对象方法）
         */
        Integer var = 100;
        System.out.println("测试对象 var = " + var);
        // 执行 ???Value(int i) 方法将 i 转换成 byte 类型
        byte v1 = var.byteValue();
        System.out.println("byte:" + v1);
        // 执行 ???Value(int i) 方法将 i 转换成 short 类型
        short v2 = var.shortValue();
        System.out.println("short:" + v2);
        // 执行 ???Value(int i) 方法将 i 转换成 int 类型
        int v3 = var.intValue();
        System.out.println("int:" + v3);
        // 执行 ???Value(int i) 方法将 i 转换成 long 类型
        long v4 = var.longValue();
        System.out.println("long:" + v4);
        // 执行 ???Value(int i) 方法将 i 转换成 float 类型
        float v5 = var.floatValue();
        System.out.println("float:" + v5);
        // 执行 ???Value(int i) 方法将 i 转换成 double 类型
        double v6 = var.doubleValue();
        System.out.println("double:" + v6);
        // 执行 ???To(Integer anotherInteger) 数字比较两个 Integer对象
        Integer x = 5;
        Integer y = 35;
        System.out.print(x.compareTo(y) + " ");
        x = 35;
        System.out.print(x.compareTo(y) + " ");
        x = 40;
        System.out.println(x.compareTo(y) + " ");


        /**
         * 静态属性和方法
         */
        // 请输出 Integer 类型的最大值
        System.out.println("====================");
        System.out.println(Integer.MAX_VALUE);
        // 请输出 Integer 类型的最小值
        System.out.println(Integer.MIN_VALUE);
        // 执行 ???Int(String s)，将字符串参数解析为带符号的十进制整数
        System.out.println(Integer.parseInt("999"));
        // 执行 ???(int x, int y)，数字比较两个 Integer对象
        Integer x1 = 15;
        Integer y1 = 8;
        System.out.println(x1.compareTo(y1));
        // 执行 ???(int a, int b)，返回两个 int的较大值
        System.out.println(Integer.max(13, 25));
        // 执行 ???(int a, int b)，返回两个 int的较小值
        System.out.println(Integer.min(21, 4));
        // 执行 ???(int a, int b)，根据+运算符将两个整数相加
        System.out.println(Integer.sum(24, 56));
        // 执行 to???String(int i)，在基数2中返回整数参数的字符串表示形式为无符号整数（转成2进制）
        System.out.println(Integer.toBinaryString(1223));
        // 执行 to???String(int i)，返回整数参数的字符串表示形式，作为16位中的无符号整数（转成16进制）
        System.out.println(Integer.toHexString(14));
        // 执行 to???String(int i)，在基数8中返回整数参数的字符串表示形式为无符号整数（转成8进制）
        System.out.println(Integer.toOctalString(34));
        // 执行 ???Of(int i)，返回一个 Integer指定的 int值的 Integer实例（int 转 Integer）
        System.out.println(Integer.valueOf(213));
        // 执行 ???Of(String s)，返回一个 Integer对象，保存指定的值为 String（String 转 Integer）
        System.out.println(Integer.valueOf("1844510"));
    }

    /**
     * Character 练习
     */
    public void testCharacter() {
        /**
         * 构造方法
         */
        System.out.println("====================");
        // 请用构造方法创建一个 Character 对象
        Character ch = new Character('3');
        System.out.println(ch);
        /**
         * 静态属性
         */
        // 请输出 char 的最大值
        System.out.println(Character.MAX_RADIX);
        // 请输出 char 的最小值
        System.out.println(Character.MIN_RADIX);
        /**
         * 实例方法
         */
        // 执行 ???Value() 返回此 Character对象的值
        Character c1 = new Character('v');
        System.out.println(c1.charValue());
        // 执行 ???To(Character anotherCharacter) 数字比较两个 Character对象。
        Character c2 = 'f';
        System.out.println(c2.compareTo(c1));
        /**
         * 静态方法
         */
        // 执行 is???(char ch) 确定指定的字符是否是数字
        System.out.println(Character.isDigit('2'));
        System.out.println(Character.isDigit('c'));
        // 执行 is???(char ch) 确定指定的字符是否是一个字母。
        System.out.println(Character.isLetter('3'));
        System.out.println(Character.isLetter('x'));
        // 执行 is???(char ch) 确定指定的字符是否是小写字符。
        System.out.println(Character.isLowerCase('s'));
        System.out.println(Character.isLowerCase('S'));
        // 执行 is???(char ch) 确定指定的字符是否为大写字符。
        System.out.println(Character.isUpperCase('s'));
        System.out.println(Character.isUpperCase('S'));
        // 执行 is???(char ch) 确定指定的字符是否是Unicode空格字符。
        System.out.println(Character.isSpaceChar(' '));
        // 执行 to???(char ch) 使用UnicodeData文件中的案例映射信息将字符参数转换为大写。
        System.out.println(Character.toUpperCase('d'));
        // 执行 to???(char ch) 使用UnicodeData文件中的大小写映射信息将字符参数转换为小写。
        System.out.println(Character.toLowerCase('D'));
        // 执行 ???Of(char c)  返回一个 表示指定的 char值的 Character实例。
        System.out.println(Character.valueOf('w'));
    }

    /**
     * Boolean 练习
     */
    public void testBoolean() {
        /**
         * 构造方法
         */
        System.out.println("=================");
        // 使用 boolean值 创建 Boolean对象
        Boolean bool = new Boolean(true);
        System.out.println(bool);
        // 使用 String值 创建 Boolean对象
        String s = "acs";
        Boolean bool1 = new Boolean(s);
        System.out.println(bool1);
        /**
         * 静态属性
         */
        // 请在控制台输出 Boolean对象对应于原始值 false 。
        System.out.println(Boolean.FALSE);
        // 请在控制台输出 Boolean对象对应于原始值 true 。
        System.out.println(Boolean.TRUE);
        /**
         * 实例方法
         */
        // 执行 ???Value() 将此 Boolean对象的值作为布尔基元返回。
        Boolean b1 = new Boolean("true");
        System.out.println(b1.booleanValue());
        // 执行 ???To(Boolean b) 将此 Boolean实例与另一个实例进行比较。
        System.out.println(b1.compareTo(false));
        /**
         * 静态方法
         */
        // 执行 ???(boolean x, boolean y) 比较两个 boolean值。
        System.out.println(Boolean.compare(true, false));
        // 执行 get???(String name) 返回 true当且仅当由参数命名的系统属性存在且等于字符串 "true" 。
        System.out.println(Boolean.getBoolean("true"));

        String str = "true";
        System.setProperty("key", str);
        System.out.println(Boolean.getBoolean("key"));
        // 执行 logical???(boolean a, boolean b) 返回将逻辑AND运算符应用于指定的 boolean操作数的结果。
        System.out.println(Boolean.logicalAnd(false, true));
        // 执行 logical???(boolean a, boolean b) 返回将逻辑OR运算符应用于指定的 boolean操作数的结果。
        System.out.println(Boolean.logicalOr(false, true));
        // 执行 ???Boolean(String s) 将字符串参数解析为布尔值。
        System.out.print(Boolean.parseBoolean("true") + " ");  //true
        System.out.print(Boolean.parseBoolean("false") + " "); //false
        System.out.println(Boolean.parseBoolean("a")); //false
        // 执行 ???Of(boolean b) 返回一个 Boolean指定的 boolean值的 Boolean实例。
        System.out.println(Boolean.valueOf(true));
        System.out.println(Boolean.valueOf(false));
        // 执行 ???Of(String s) 返回一个 Boolean ，其值由指定的字符串表示。
        System.out.println(Boolean.valueOf("true"));
        System.out.println(Boolean.valueOf("false"));
    }

}
