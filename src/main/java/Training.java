
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import java.time.*;



public class Training {
    public static boolean isLeapYear(int year) {
        return Year.isLeap(year);
        /*
        Years divisible by 4 are leap years,
but years divisible by 100 are not leap years,
but years divisible by 400 are leap years.
         */
    }

    public static void main(String[] args) {
            System.out.println(isLeapYear(2100));
    }
}
