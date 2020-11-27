package homework21;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Date date = new Date();

        LocalDate localDate = getLocalDate(date);
        System.out.println("Convert to localDate");
        System.out.println(localDate);

        LocalTime localTime = getLocalTime(date);
        System.out.println("Convert to localTime");
        System.out.println(localTime);

        LocalDateTime localDateTime = getLocalDateTime(date);
        System.out.println("Convert to localDateTime");
        System.out.println(localDateTime);
    }

    public static LocalTime getLocalTime(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
    }
    public static LocalDate getLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
    public static LocalDateTime getLocalDateTime(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
}
