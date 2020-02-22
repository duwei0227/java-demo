package top.probiecoder.corejava.web;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class InetAddressTest {
    public static void main(String[] args) throws UnknownHostException {
        System.out.println(InetAddress.getLocalHost());
        String host = "google.com";
        InetAddress[] inetAddresses = InetAddress.getAllByName(host);
        Arrays.stream(inetAddresses).forEach(System.out::println);
    }
}
