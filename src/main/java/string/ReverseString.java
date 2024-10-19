package string;

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReverseString {

    public static String solution(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public static String solution2(String str) {
        return Stream.of(str.split(""))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.joining());
    }

    public static String solution3(String str) {
        return str.chars()  // Convert the string to an IntStream of character codes (ASCII/Unicode).
                .mapToObj(c -> String.valueOf((char) c))  // Convert each character code back to a string.
                .sorted(Comparator.reverseOrder()) // Sort in reverse order.
                .collect(Collectors.joining());  // Join sorted characters back into a single string.
    }

    public static void main(String[] args) {
        System.out.println(solution("Hello"));
        System.out.println(solution2("Hello"));
        System.out.println(solution3("Hello"));
    }
}
