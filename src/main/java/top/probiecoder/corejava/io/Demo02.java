package top.probiecoder.corejava.io;

import java.io.*;

public class Demo02 {
    public static void main(String[] args) {
        try (DataInputStream din = new DataInputStream(new BufferedInputStream(new FileInputStream("a.txt")))){
            System.out.println(din.readLong());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
