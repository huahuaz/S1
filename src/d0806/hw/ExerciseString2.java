package d0806.hw;

import java.util.Arrays;

public class ExerciseString2 {
    /**
     * 中国电信号码格式验证 手机段： 133，153， 180，181，189,173， 177
     **/
    private static final String CHINA_TELECOM_PATTERN = "133,153,180,181,189,173,177";

    /**
     * 中国联通号码格式验证 手机段：130，131，132，155，156，185，186,145,176，185
     **/
    private static final String CHINA_UNICOM_PATTERN = "130,131,132,155,156,185,186,145,176,185";

    /**
     * 中国移动号码格式验证
     * 手机段：134，135，136，137，138，139，150，151，152，158，159，182，183，184,147,178，184
     **/
    private static final String CHINA_MOBILE_PATTERN = "134,135,136,137,138,139,150,151,152,158,159,182,183,184,147,178,184";

    public static void main(String[] args) {
        ExerciseString2 e2 = new ExerciseString2();
        e2.getISP("13017842235");
    }

    /**
     * 手机号码前三位代表运营商
     * 中国电信	2G/3G号段：133，153， 180，181，189
     * 4G号段：173， 177
     * 中国联通	2G/3G号段：130，131，132，155，156，185，186
     * 3G上网卡：145
     * 4G号段：176，185
     * 中国移动	2G/3G号段：134，135，136，137，138，139，150，151，152，158，159，182，183，184
     * 3G上网卡：147
     * 4G号段：178，184
     * 请根据传入的电话号码, 返回对应的运营商的名称
     */
    public String getISP(String phoneNumber) {
        /*String[] p1 = {"155","133","136","181","186","187","189","177"};
        Arrays.sort(p1);

        String pre = phoneNumber.substring(0,3);
        System.out.println(pre);

        int index = Arrays.binarySearch(p1,pre);
        System.out.println(index);
        Arrays.sort(p1);
        System.out.println(p1);
        System.out.println(Arrays.toString(p1));*/
        //电信
        String[] dx = CHINA_TELECOM_PATTERN.split(",");
        Arrays.sort(dx);
        //System.out.println(Arrays.toString(dx));
        //联通
        String[] lt = CHINA_UNICOM_PATTERN.split(",");
        Arrays.sort(lt);
        //System.out.println(Arrays.toString(lt));
        //移动
        String[] yd = CHINA_MOBILE_PATTERN.split(",");
        Arrays.sort(yd);
        //System.out.println(Arrays.toString(yd));

        String pre = phoneNumber.substring(0, 3);
        //System.out.println(pre);

        int index = 0;
        if (Arrays.binarySearch(dx, pre) >= 0) {
            index = Arrays.binarySearch(dx, pre);
            System.out.println("该手机号运营商为:" + "中国电信");
        } else if (Arrays.binarySearch(lt, pre) >= 0) {
            index = Arrays.binarySearch(lt, pre);
            System.out.println("该手机号运营商为:" + "中国联通");
        } else if (Arrays.binarySearch(yd, pre) >= 0) {
            index = Arrays.binarySearch(yd, pre);
            System.out.println("该手机号运营商为:" + "中国移动");
        }
        //System.out.println(index);
        /*int index = Arrays.binarySearch(lt,pre);
        System.out.println(index);
*/
        return "中国电信 or 中国联通 or 中国移动";
    }

    /**
     * 身份证号码规则：
     * 前1、2位数字表示：所在省份的代码；
     * 第3、4位数字表示：所在城市的代码；
     * 第5、6位数字表示：所在区县的代码；
     * 第7-14位数字表示：出生年、月、日；
     * 第15、16位数字表示：所在地的派出所的代码；
     * 第17位数字表示性别：奇数表示男性，偶数表示女性；
     * 第18位数字是校检码
     * 任意给出一个身份证号码，在控制台输所有的出个人信息，
     * 日期格式：xxxx年xx月xx日
     * 性别：显示男，女
     * 其他代码：显示原值
     */
    public void parseId(String id) {

    }

    /**
     * 研究网络上垃圾邮件的信息和词，请将经常在垃圾邮件中看到的30个词创建成一个列表。写一个方法，用户输入email信息，
     * 扫描这些词是否出现在这个邮件中，只要在信息中出现一次这些单词，就给这个词记一分，根据最后的得分，给这个邮件记一个等级，
     * 返回该邮件的等级
     *
     * @param email
     */
    public int checkJunkMail(String email) {
        return 0;
    }

}
