package stream;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Map {
    public static int[] invert(int[] array) {
        return Arrays.stream(array).map(i -> (-1) * i).toArray();
    }

    public static String fakeBin(String numberString) {
        return Arrays.stream(numberString.split("")).map(s -> {
            if (Integer.parseInt(s) < 5) {
                return "0";
            } else {
                return "1";
            }
        }).collect(Collectors.joining());
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(invert(new int[]{1, -2, 3, -4, 5})));
    }
}
