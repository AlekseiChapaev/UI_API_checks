package stream;

import java.util.Arrays;
import java.util.List;

public class MapToInt {
    public static int sum(List<?> mixed) {

        return mixed.stream().mapToInt(obj -> {
            if(obj instanceof String) {
                return Integer.parseInt((String)obj);
            } else {
                return (Integer)obj;
            }
        }).sum();

        //return mixed.stream().mapToInt(o -> Integer.parseInt(o.toString())).sum();
    }

    public static int points(String[] games) {
        return Arrays.stream(games).mapToInt(s -> {
            if (Integer.parseInt(s.substring(0, 1)) > Integer.parseInt(s.substring(2))) {
                return 3;
            } else if (Integer.parseInt(s.substring(0, 1)) == Integer.parseInt(s.substring(2))) {
                return 1;
            } else return 0;
        }).sum();
    }

    public static void main(String[] args) {
        System.out.println(sum(List.of("3", "5", 2, 10)));
        System.out.println(points(new String[]
                {"1:0","2:0","3:0","4:0","2:1","1:3","1:4","2:3","2:4","3:4"}));
    }

}
