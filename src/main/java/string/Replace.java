package string;

public class Replace {

    public static String replace(final String s) {
        return s.replaceAll("[aeouiAEOUI]", "!");
    }

    public static void main(String[] args) {
        System.out.println(replace("Hello!"));
    }
}
