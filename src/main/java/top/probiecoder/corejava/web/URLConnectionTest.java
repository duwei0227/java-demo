package top.probiecoder.corejava.web;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class URLConnectionTest {
    public static void main(String[] args) {
        try {
            String urlName = "http://horstmann.com";
            URL url = new URL(urlName);
            URLConnection connection = url.openConnection();
            connection.setRequestProperty("Authorization", "Basic XXXXXX");
            connection.connect();

            Map<String, List<String>> headers = connection.getHeaderFields();
            for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
                String key = entry.getKey();
                entry.getValue().forEach(value -> System.out.println(key + ": " + value));
            }
            System.out.println(connection.getContentType());
            System.out.println(connection.getContentLength());
            System.out.println(connection.getContentEncoding());
            System.out.println(connection.getDate());

            String encoding = connection.getContentEncoding();
            if (encoding == null) {
                encoding = StandardCharsets.UTF_8.name();
            }
            try (Scanner in = new Scanner(connection.getInputStream(), encoding)){
                for (int n = 1; in.hasNextLine() && n <= 10; n++) {
                    System.out.println(in.nextLine());
                }
                if (in.hasNextLine()) {
                    System.out.println(". . .");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
