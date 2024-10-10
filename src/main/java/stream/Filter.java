package stream;

import java.util.List;
import java.util.stream.Collectors;

public class Filter {
    static int countCharOccurrences(String s, char c) {
        return (int)s.chars().filter(symbol -> symbol == c).count();
    }

    public static List<String> getStringStartsWithLetter(List<String> str, String letter) {
        return str.stream().filter(s -> s.startsWith(letter)).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(countCharOccurrences("missippi", 'r'));
        System.out.println(getStringStartsWithLetter(List.of("ds", "wdw", "wd", "qwe", "gd", "35", "dhw"), "d"));

    }
}
