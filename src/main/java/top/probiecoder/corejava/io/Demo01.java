package top.probiecoder.corejava.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;

public class Demo01 {
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
        try (FileInputStream fileInputStream = new FileInputStream("a.txt");){
            System.out.println(fileInputStream.available());
            /*int data;
            while ((data = fileInputStream.read()) != -1) {
                System.out.print((char) data);
            }*/
            byte[] data = new byte[fileInputStream.available()];
            fileInputStream.read(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
