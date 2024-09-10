
import stream.SummaryStatistics;

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
        int[][] array = {{1, 2, 3, 4, 5}, {6, 7, 8, 9}, {-1, -2, -3, -4}, {-5, -6}};

        System.out.println(Arrays.stream(array).flatMapToInt(min -> Arrays.stream(min)).min().getAsInt());
    }
}
