package stream;

import java.util.stream.Stream;

public class TakeWhile {
    public static void main(String[] args) {
        Stream.iterate(0, n -> n + 1)
                .map(i -> Math.pow(5, i))
                .takeWhile(i -> i < 15000)
                .forEach(System.out::println);
    }
}