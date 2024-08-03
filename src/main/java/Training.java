
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;


public class Training {
    public static String highAndLow(String numbers) {
        var res = Arrays.stream(numbers.split(" ")).mapToInt(Integer::parseInt).summaryStatistics();

        return res.getMax() + " " + res.getMin();
    }

    public static void main(String[] args) {
            System.out.println(highAndLow("8 3 -5 42 -1 0 0 -9 4 7 4 -4"));
    }
}
