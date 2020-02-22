package top.probiecoder.corejava.io;

import org.fusesource.hawtbuf.BufferInputStream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.nio.Buffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FilesDemo {
    public static void main(String[] args) throws IOException {
        Path base = Paths.get("a.txt");
        byte[] data = Files.readAllBytes(base);
        // 转为字符串
        System.out.println(new String(data, StandardCharsets.UTF_8));
        // 逐行读取
        List<String> lines = Files.readAllLines(base, StandardCharsets.UTF_8);
        lines.forEach(System.out::println);
        // 读入结果为Stream
        Stream<String> stream = Files.lines(base);
        stream.forEach(System.out::println);
        // 转为IO流
        InputStream is = Files.newInputStream(base, StandardOpenOption.READ);
        System.out.println((char) is.read());

        Files.write(base, lines, StandardOpenOption.APPEND);

        // 创建文件和目录
    }
}
