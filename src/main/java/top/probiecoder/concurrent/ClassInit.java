package top.probiecoder.concurrent;

public class ClassInit {
    static {
//        System.out.println(x);
        x = 100;
    }
    private static int x = 10;

    public static void main(String[] args) {
        System.out.println(ClassInit.x);
    }
}
