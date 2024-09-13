package stream;

import java.util.Arrays;

public class Reduce {

    public static String sort(String[] ss) {
        return Arrays.stream(ss)
                .reduce((s1, s2) -> s1.length() < s2.length() ? s1 : s2)
                .get();

    }

    public static void main(String[] args) {
        System.out.println(sort(new String[]{"hello", "world", "here", "wasce", "are"}));
    }
}
