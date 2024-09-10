package stream;

import java.util.Arrays;

public class FlatMap {
    public static void main(String[] args) {
        String[][] array = {{"Привет", "всем", "кто"}, {"изучает", "язык", "программирования"}, {"java"}};

        System.out.println(Arrays.stream(array)
                .flatMap(i -> Arrays.stream(i))
                .filter(i -> !i.contains("е"))
                .count());
    }
}
