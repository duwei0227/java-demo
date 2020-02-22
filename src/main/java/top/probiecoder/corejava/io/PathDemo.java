package top.probiecoder.corejava.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathDemo {
    public static void main(String[] args) throws IOException {
        /*// 构建一个Path路径
        Path basePath = Paths.get("path", "test");
        System.out.println(basePath);
        System.out.println(basePath.toAbsolutePath());
        System.out.println(System.getProperty("user.dir"));
        System.out.println(Paths.get("/home", "path"));*/

        /*Path base = Paths.get("/home/path");
        Path target = base.resolve("/home/work");
        System.out.println(target);
        Path base = Paths.get("/home/path");
        Path target = base.resolveSibling("/home/work");
        System.out.println(target);*/
        Path base = Paths.get("/home/path");
        Path other = Paths.get("/home/user/work");
        Path target = base.relativize(other);
        System.out.println(target);

        System.out.println(target.toAbsolutePath());
        System.out.println(target.toAbsolutePath().normalize());
    }
}
