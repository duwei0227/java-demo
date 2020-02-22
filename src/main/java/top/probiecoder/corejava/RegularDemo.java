package top.probiecoder.corejava;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularDemo {
    public static void main(String[] args) {
        String text = "This is my personal info. My cellphone " +
                "number 15301234567 and email probiecoder@gmail.com.Today i will learn regex";
        // 简单匹配数字
        String regex  = "\\d{3,}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            System.out.println(matcher.group());
        }

        // email匹配--限制支持邮箱列表 gmail.com qq.com 163.com
        regex = "\\w{3,}@(gmail|qq|163).com";
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(text);
        if (matcher.find()) {
            System.out.println(matcher.group());
        }

        text = "java,Java,aJava,iJava";
        regex = "\\w+,(Java),aJava,(iJava)";
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(text);
        if (matcher.find()) {
            System.out.println(matcher.group());
            System.out.println(matcher.groupCount());
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
        }
    }
}
