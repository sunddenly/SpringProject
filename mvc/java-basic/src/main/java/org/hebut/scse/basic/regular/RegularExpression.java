package org.hebut.scse.basic.regular;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jxy on 2016/9/6.
 * "^[\\s&&[^\\n]]*\\n$"匹配的是以0或多个空格（[\\s&&[^\\n]]*）开头，并以换行符（\\n）结束的数据，所以你的“\n"自然是匹配成功的。
 */
public class RegularExpression {
    private static void mathEmail() {
        //括号部分可以匹配多个字符串\w{3,20}@\w+\.(com|org|cn|net)
        String regStr = "^[a-zA-Z0-9_]+@[a-zA-Z0-9]+(\\.com|\\.cn|\\.net)+$";
        regStr = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
        Pattern pattern = Pattern.compile(regStr);//注册正则表达式
        String mailStr = "chang_2013@chang.com.cn.cn.com";
        //匹配字符串，返回描述匹配结果的Matcher实例
        Matcher matcher = pattern.matcher(mailStr);
        //通过调用Matcher的find方法得知是否匹配成功
        if (matcher.find()) {
            System.out.println("邮箱匹配成功！");
        } else {
            System.out.println("邮箱格式错误！");
        }
    }
    private  static void mathDate(){
        String regStr = "(\\d{4})-(\\d{2}-(\\d\\d))";
        String date = "2008-03-21;2009-04-21*2017-10-30";
        Matcher matcher = Pattern.compile(regStr).matcher(date);
        while (matcher.find()) {
            System.out.println("匹配子串："+matcher.group());
            System.out.println("匹配子串构件：" + matcher.group(0));
            System.out.println("匹配子串构件：" + matcher.group(1));
            System.out.println("匹配子串构件：" + matcher.group(2));
            System.out.println("匹配子串构件：" + matcher.group(3)+"\n");
        }
    }
    public static void main(String[] args) {
        //Non capture
        String reg = "(?:[ab])";
        String s = "abaa";
        Matcher matcher = Pattern.compile(reg).matcher(s);
        while (matcher.find()) {
            System.out.println("匹配子串："+matcher.group());
            System.out.println("子串分组0："+matcher.group(0));
            System.out.println("子串分组0："+matcher.group(1));
        }
    }

    private static void reverseLead() {
        String reg = "([ab])\\1";
        String s = "abaa";
        Matcher matcher = Pattern.compile(reg).matcher(s);
        while (matcher.find()) {
            System.out.println("匹配子串："+matcher.group());
            System.out.println("子串分组0："+matcher.group(0));
            System.out.println("子串分组0："+matcher.group(1));
        }
        /**
         匹配子串：aa
         子串分组0：aa
         子串分组0：a
         */
    }

    private static void StringReg() {
        String[] msgs = {"Java has regular expressions in JDK1.4",
                        "regular expressions now expressing in Java",
                        "Java represses oracular expressions"};

        for (String msg : msgs) {
            System.out.println(msg.replaceFirst("re\\w*", "哈哈:)"));
            System.out.println(Arrays.toString(msg.split(" ")));
        }
    }

    private static void replace() {
        String[] msgs = {"Java has regular expressions in JDK1.4",
                "regular expressions now expressing in Java",
                "Java represses oracular expressions"};
        /**
         * " re\\w"：表示每行中以"空格+re开头"的子串，都会被匹配
         * "^re\\w"：匹配的是行，每行开头是re时才能进行下一步匹配
         */
        Pattern p = Pattern.compile(" re\\w*|^re\\w*");
        Matcher matcher = null;
        for (int i = 0; i < msgs.length; i++) {
            if (matcher == null) {
                matcher = p.matcher(msgs[i]);
            } else {
                matcher.reset(msgs[i]);
            }
            System.out.println(matcher.replaceAll(" 笑笑:)"));
        }
    }


    private static void Matches() {
        String[] mails = {"798103175@qq.com", "cakin24@163.com",
                "chengqiuming@w3.org", "c00303563@abc.xx"};
        String mailRegEx = "\\w{3,20}@\\w+\\.(com|org|cn|net|gov)";
        Pattern mailPattern = Pattern.compile(mailRegEx);
        Matcher matcher = null;
        for (String mail : mails) {
            if (matcher == null) {
                matcher = mailPattern.matcher(mail);
            } else {
                matcher.reset(mail);
            }
            String result = mail + (matcher.matches() ? "是" : "不是")
                    + "一个有效的邮件地址！";
            System.out.println(result);
        }
    }


    private static void startEnd() {
        // 创建一个Pattern对象，并用它建立一个Matcher对象
        String regStr = "Java is very easy!";
        System.out.println("目标字符串是：" + regStr);
        Matcher m = Pattern.compile("\\w+").matcher(regStr);
        while (m.find()) {
            System.out.println(m.group() + "子串的起始位置："
                    + m.start() + "，其结束位置：" + m.end());
        }
    }

    private static void findGroup() {
        //爬取得网页源码
        String str = "我想求购一本《Java典型应用》，尽快联系我13500006666"
                + "交朋友，电话号码是18811125565"
                + "出售二手电脑，联系方式15899903312";
        // 创建一个Pattern对象，并用它建立一个Matcher对象，该正则表达式只抓取13X和15X段的手机号
        // 实际要抓取哪些电话号码，只要修改正则表达式即可
        Matcher m = Pattern.compile("((13\\d)|(15\\d))\\d{8}")
                .matcher(str);
        // 将所有符合正则表达式的子串（电话号码）全部输出
        while (m.find()) {
            System.out.println(m.group());
        }
    }

    /**
     * 最大匹配
     */
    private static void Greediness() {
        String test = "a<tr>aava </tr>abb ";
        String reg = "<.+>";
        System.out.println(test.replaceAll(reg, "###"));
    }

    /**
     * 最小匹配
     */
    private static void reluctant() {
        String test = "a<tr>aava </tr>abb ";
        String reg = "<.+?>";//匹配的是</tr>和<tr>
        System.out.println(test.replaceAll(reg, "###"));
    }

    /**
     * 完全匹配
     */
    private static void possessive() {
        String test = "a<tr>aava </tr>abb ";
        String reg = "<.++>";
        String reg2 = "<tr>";
        System.out.println(test.replaceAll(reg, "###"));//没有匹配成功，a<tr>aava </tr>abb
        System.out.println(test.replaceAll(reg2, "###"));//因为没有数量通配，因此匹配一次就结束了a###aava </tr>abb
    }
    /**
     *
     */

}
