package stream;

import java.util.Arrays;

public class Map {
    public static int[] invert(int[] array) {
        return Arrays.stream(array).map(i -> (-1) * i).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(invert(new int[]{1, -2, 3, -4, 5})));
    }
}
