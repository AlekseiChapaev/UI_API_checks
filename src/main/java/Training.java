
import java.text.DecimalFormat;
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

    public static String relation(int a, int b) {
        return (a+b) % 2 != 0 ? "some variable is odd" : "maybe a and b are even";
    }
    public static void main(String[] args) {
        int[] array = {9, 2, 6, 4, 5, 12, 7, 8, 6};

        DecimalFormat df = new DecimalFormat("#.##");
        String formattedValue = df.format(Arrays.stream(array).average().getAsDouble());
        System.out.println(formattedValue);

        Arrays.stream(array).average().ifPresent(System.out::println);

    }
}
