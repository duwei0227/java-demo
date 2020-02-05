package top.probiecoder.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(4);
        Test1 test1 = new Test1();
        for (int i = 0; i < 5; i++) {
            test1.setName(String.valueOf(i));
//            Test1 test11 = new Test1(String.valueOf(i));
            service.submit(test1);
        }
    }
}

class Test1 implements Runnable {
    private String name;

    public Test1() {

    }

    public Test1(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(this.name);
        try {
            test();
        } catch (Exception e) {
            System.out.println("222222");
        }
    }

    private void test() {
        String a = null;
        a.replace("a", "b");
        System.out.println("=======");
    }
}