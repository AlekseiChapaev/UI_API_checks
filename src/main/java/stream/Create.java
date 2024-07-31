package stream;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Create {
    public static String countingSheep(int num) {
        return Stream.iterate(1, n -> n + 1)
                .limit(num)
                .map(n -> n + " sheep...")
                .collect(Collectors.joining());
    }

    public static String countingSheep2(int num) {
        return IntStream.rangeClosed(1, num)
                .mapToObj(n -> n + " sheep...")
                .collect(Collectors.joining());
    }

    public static void main(String[] args) {
        System.out.println(countingSheep(4));
        System.out.println(countingSheep2(4));
    }
}
