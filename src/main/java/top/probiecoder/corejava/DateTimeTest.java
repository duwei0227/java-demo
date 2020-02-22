package top.probiecoder.corejava;

import java.time.Duration;
import java.time.Instant;

public class DateTimeTest {
    public static void main(String[] args) {
        Instant instant = Instant.now();
        System.out.println(instant);
        Instant after = instant.plusSeconds(1000);
        Duration duration = Duration.between(instant, after);
        System.out.println(duration.toDays());
        System.out.println(duration.toHours());
        System.out.println(duration.toMinutes());
        System.out.println(duration.toSeconds());
    }
}
