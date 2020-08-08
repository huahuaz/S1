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

    //身份证省份代码
    /*private static final String PROVINCE = "";*/

    //垃圾邮箱词汇
    private static final String E_MAIL = "马上买,最优价格,朋友,哈喽,最低价,免风险,点击下面,会员,订阅,优惠,相关重要信息,试用,账单,信用,保险,挣钱,垃圾邮件,免费,赢家,百万美元,支票,老板,密码,电话,恭喜,客户,打开,认证,豪华,申请";

    public static void main(String[] args) {
        ExerciseString2 e2 = new ExerciseString2();
        System.out.println("该电话所在运营商为:" + e2.getISP("18917842235"));
        e2.parseId("430204200003252020");
        System.out.println("该邮箱敏感词汇:" + e2.checkJunkMail("这次活动很优惠，一定要马上买，还能免费试用一个月") + "个");
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
            return "中国电信";
        } else if (Arrays.binarySearch(lt, pre) >= 0) {
            index = Arrays.binarySearch(lt, pre);
            return "中国联通";
        } else if (Arrays.binarySearch(yd, pre) >= 0) {
            index = Arrays.binarySearch(yd, pre);
            return "中国移动";
        } else {
            return "未知号码";
        }
        //System.out.println(index);
        /*int index = Arrays.binarySearch(lt,pre);
        System.out.println(index);
*/
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
        while (true) {
            if (id.length() == 18) {
                String province = id.substring(0, 2);
                String city = id.substring(2, 4);
                String county = id.substring(4, 6);
                System.out.println("该身份证所在省份代码:" + province + " 城市代码:" + city + " 区县代码" + county);

                String year = id.substring(6, 10);
                String mon = id.substring(10, 12);
                String day = id.substring(12, 14);
                System.out.println("生日:" + year + "年" + mon + "月" + day + "日");

                String place = id.substring(14, 16);
                System.out.println("所在地派出所代码:" + place);

                String sex = id.substring(16, 17);
                int s = Integer.parseInt(sex);
                if (s % 2 == 0) {
                    System.out.println("性别:女");
                } else {
                    System.out.println("性别:男");
                }

                String x = id.substring(17, 18);
                System.out.println("校验码:" + x);
                break;
            } else {
                System.out.println("您输入的身份证号码有误,请重新输入!");
                break;
            }
        }
    }

    /**
     * 研究网络上垃圾邮件的信息和词，请将经常在垃圾邮件中看到的30个词创建成一个列表。写一个方法，用户输入email信息，
     * 扫描这些词是否出现在这个邮件中，只要在信息中出现一次这些单词，就给这个词记一分，根据最后的得分，给这个邮件记一个等级，
     * 返回该邮件的等级
     *
     * @param email
     */
    public int checkJunkMail(String email) {
        String[] em = E_MAIL.split(",");
        Arrays.sort(em);

        int count = 0;
        for (int i = 0; i < em.length; i++) {
            if (email.contains(em[i])) {
                count++;
            }
        }
        if (count == 0) {
            System.out.println("该邮件安全等级为:A");
        } else if (count > 0 && count <= 5) {
            System.out.println("该邮件安全等级为:B");
        } else if (count > 5 && count <= 10) {
            System.out.println("该邮箱安全等级为:C");
        } else {
            System.out.println("该邮箱敏感词汇过多，请勿点开!");
        }
        return count;
    }

}
