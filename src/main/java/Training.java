
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import java.time.*;



public class Training {
    public static String frontBack(String str) {
        if(str.length() > 1) {

        char f = str.charAt(0);
        char l = str.charAt(str.length() - 1);

        StringBuilder sb = new StringBuilder(str);
        sb.deleteCharAt(str.length() - 1).deleteCharAt(0).append(f).insert(0, l);
        return sb.toString();}
        else return str;
    }

    public static void main(String[] args) {
            System.out.println(frontBack("a"));

    }
}
