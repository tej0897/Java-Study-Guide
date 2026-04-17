/**
 * Day 34 - Java 8 Features: java.time (Date/Time API)
 */

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateTimeApiExample {
    public static void main(String[] args) {
        System.out.println("=== java.time (Java 8 Date/Time API) ===\n");

        LocalDate today = LocalDate.now();
        LocalTime nowTime = LocalTime.now();
        LocalDateTime now = LocalDateTime.now();

        System.out.println("Today: " + today);
        System.out.println("Time:  " + nowTime.withNano(0));
        System.out.println("Now:   " + now.withNano(0));

        LocalDate birthday = LocalDate.of(2000, 1, 1);
        System.out.println("\nBirthday: " + birthday);
        System.out.println("Days since 2000-01-01 (approx): " + Duration.between(birthday.atStartOfDay(), today.atStartOfDay()).toDays());

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm");
        System.out.println("\nFormatted now: " + now.format(fmt));
        System.out.println("System Zone: " + ZoneId.systemDefault());

        System.out.println("\nKey Points:");
        System.out.println("1. java.time is immutable and thread-safe");
        System.out.println("2. Prefer it to java.util.Date/Calendar in modern code");
    }
}

