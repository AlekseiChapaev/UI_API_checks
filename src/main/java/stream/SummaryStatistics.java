package stream;

import java.util.stream.IntStream;

public class SummaryStatistics {
    public static void highAndLow(int[] arr) {
        var res = IntStream.of(arr).summaryStatistics();
        System.out.println("max = " + res.getMax());
        System.out.println("min = " + res.getMin());
        System.out.println("count = " + res.getCount());
        System.out.println("avarage = " + res.getAverage());
        System.out.println("um = " + res.getSum());
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 5, 34, -67, 654, 73, 0};
        highAndLow(array);
    }
}
