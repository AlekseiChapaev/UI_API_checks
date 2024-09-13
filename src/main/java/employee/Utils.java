package employee;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {

    public static String findEmployee(String name, Employee[] employees) {
        String res = "";
        for (Employee e : employees) {
            if (e.getName() != null && e.getName().equals(name)) {
                res = e.getClass().toString();
                break;
            } else {
                res = "No such employee";
            }
        }
        return res;
    }
}