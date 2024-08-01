public class ReverseString {

    public static String solution(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("Hello"));
    }
}
