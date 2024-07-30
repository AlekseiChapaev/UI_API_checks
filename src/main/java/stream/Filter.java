package stream;

public class Filter {
    static int countCharOccurrences(String s, char c) {
        return (int)s.chars().filter(symbol -> symbol == c).count();
    }

    public static void main(String[] args) {
        System.out.println(countCharOccurrences("missippi", 'r'));
    }
}
