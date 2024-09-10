package stream;

import java.text.DecimalFormat;
import java.util.Arrays;

public class ifPresent {
    public static void main(String[] args) {
        int[] array = {9, 2, 6, 4, 5, 12, 7, 8, 6};

        Arrays.stream(array).average().ifPresent(avg -> System.out.println(avg));
    }
}
