package top.probiecoder.classloader;

public class HelloWorlds {
    static {
        System.out.println("Hello Worldss class is Initialized");
    }

    public String welcome() {
        return "Hello World";
    }
}
