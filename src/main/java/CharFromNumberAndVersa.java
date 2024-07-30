public class CharFromNumberAndVersa {
    public static char getCharFromInt(int c) {
        return (char)c;
    }

    public static int getIntFromChar(char ch) {
        return (int)ch;
    }

    public static void main(String[] args) {
        System.out.println(getCharFromInt(65));
        System.out.println(getIntFromChar('A'));
    }
}
