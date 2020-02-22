package top.probiecoder.corejava.web;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class EchoServer {
    public static void main(String[] args) {
        // 建立连接
        try (ServerSocket server = new ServerSocket(8189)) {
            // 等待客户端连接
            try (Socket client = server.accept()) {
                InputStream inStream = client.getInputStream();
                OutputStream outStream = client.getOutputStream();

                try (Scanner in = new Scanner(inStream, StandardCharsets.UTF_8)) {
                    PrintWriter out = new PrintWriter(new OutputStreamWriter(outStream, StandardCharsets.UTF_8), true);
                    out.println("Hello! Enter BYE to exit.");

                    // echo 客户端输入内容
                    boolean done = false;
                    while (!done && in.hasNextLine()) {
                        String line = in.nextLine();
                        out.println("Echo: " + line);
                        if (line.trim().equalsIgnoreCase("bye")) {
                            done = true;
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
