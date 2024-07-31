package stream;

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

    public static void main(String[] args) {
        System.out.println(sum(List.of("3", "5", 2, 5)));
    }

}
