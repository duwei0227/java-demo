package top.probiecoder;

import java.io.*;
import java.util.Arrays;

public class BufferedReaderDemo {
    public static void main(String[] args) throws IOException {
        // 将demo.txt文件放置到target目录，与当前类同级，内容自定义
        String path = BufferedReaderDemo.class.getClassLoader().getResource("./top/probiecoder").getPath();
        System.out.println(path);
        // BufferedReader 使用默认缓存大小 缓存大于io流大小
        // 小于
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(path + "/demo.txt")), 20)){
            // 读取一行
//            String buffer;
//            while ((buffer = reader.readLine()) != null) {
//                System.out.println(buffer);
//            }
            // 读取一个字节
//            int size = 0;
//            while ((size = reader.read()) != -1) {
//                System.out.print((char)size);
//            }

            // 读取一个数组
            int size = 0;
            char[] readChar = new char[1024];  // 字符数组大小自定义
            String buffer = "";
            while ((size = reader.read(readChar, 0, readChar.length)) != -1) {
                // 读取到的内容小于自定义字符数组，需要去除默认填充值
                if (size < readChar.length) {
                    char[] newReaderChar = Arrays.copyOf(readChar, size);
                    buffer = String.valueOf(newReaderChar);
                } else {
                    buffer = String.valueOf(readChar);
                }
                System.out.println(buffer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
