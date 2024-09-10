
import stream.SummaryStatistics;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import java.time.*;

import static io.opentelemetry.api.internal.TemporaryBuffers.chars;


public class Training {

    public static void main(String[] args) {
        String[][] array = {{"Привет", "всем", "кто"}, {"изучает", "язык", "программирования"}, {"java"}};
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if(!array[i][j].contains("е")) {
                    count++;
                }
            }
        }
        System.out.println(count);


        System.out.println(Arrays.stream(array)
                .flatMap(i -> Arrays.stream(i))
                .filter(i -> !i.contains("е"))
                .count());

    }



}
