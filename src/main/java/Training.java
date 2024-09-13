
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

    public static String sort(String[] ss) {
        return Arrays.stream(ss)
                .reduce((s1, s2) -> s1.length() < s2.length() ? s1 : s2)
                .get();
    }
    
    public static void main(String[] args) {
        System.out.println(sort(new String[]{"hello", "world", "here", "wasce", "are"}));
    }


}
