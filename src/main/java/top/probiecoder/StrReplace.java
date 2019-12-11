package top.probiecoder;

import java.util.regex.Matcher;

public class StrReplace {
    public static void main(String[] args) {
        // 单个 $ \ 替换
        String singleDollar = "abc$sef";
        System.out.println(singleDollar.replace("$", "\\$\\"));
        System.out.println(singleDollar.replace("$", "_"));
        String singleSlash = "abc\\abc";
        System.out.println(singleSlash.replace("\\", "\\\\"));
        System.out.println(singleSlash.replace("\\", "_"));
        // 多个 $ \ 替换
        String multiDollar = "abc$edf$mgl";
        System.out.println(multiDollar.replaceAll("\\\\$", "\\$"));
        System.out.println(multiDollar.replaceAll("\\\\$", "_"));
        String multiSlash = "abc\\edf\\mgl";
        System.out.println(multiSlash.replaceAll("\\", "\\\\\\\\"));
        System.out.println(multiSlash.replaceAll("\\\\", "_"));
        System.out.println(multiDollar.replaceAll(Matcher.quoteReplacement("$"), Matcher.quoteReplacement("\\$\\")));
        System.out.println(multiDollar.replaceAll(Matcher.quoteReplacement("$"), Matcher.quoteReplacement("_")));
        System.out.println(multiSlash.replaceAll(Matcher.quoteReplacement("\\"), Matcher.quoteReplacement("\\\\")));
        System.out.println(multiSlash.replaceAll(Matcher.quoteReplacement("\\"), Matcher.quoteReplacement("_")));

    }
}
