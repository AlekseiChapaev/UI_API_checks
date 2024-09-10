package stream;

import java.util.Arrays;

public class FlatMapToInt {
    public static void main(String[] args) {
        int[][] array = {{1, 2, 3, 4, 5}, {6, 7, 8, 9}, {-1, -2, -3, -4}, {-5, -6}};

        System.out.println(Arrays.stream(array)
                .flatMapToInt(min -> Arrays.stream(min))
                .min()
                .getAsInt());
    }
}
