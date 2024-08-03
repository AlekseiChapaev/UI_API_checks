package time;

import java.time.Year;

public class IsLeapYear {
    public static void main(String[] args) {
        System.out.println(Year.isLeap(2000));
        System.out.println(Year.isLeap(2100));
    }
}
