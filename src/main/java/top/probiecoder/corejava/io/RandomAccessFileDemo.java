package top.probiecoder.corejava.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo {
    public static void main(String[] args) {
        try (RandomAccessFile accessFile = new RandomAccessFile("b.dat", "rw")){
            accessFile.writeChars("ha ha");
            accessFile.seek(20);
            accessFile.writeChars("ss");
            accessFile.seek(500);
            accessFile.writeChars("bb");
            System.out.println(accessFile.getFilePointer());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
