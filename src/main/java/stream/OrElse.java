package stream;

import java.util.Arrays;

public class OrElse {

    public static void main(String[] args) {
        int[] array = {9, 2, 6, 4, 5, 12, 7, 8, 6};

        System.out.println(Arrays.stream(array).average().orElse(0.0));
    }
}
