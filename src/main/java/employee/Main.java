package employee;

public class Main {

    public static void main(String[] args) {


        Worker w1 = new Worker();
        w1.setName("Anton");

        Worker w2 = new Worker();
        w2.setName("Serg");
        Worker w3 = new Worker();
        w3.setName("Anna");

        Manager m1 = new Manager();
        m1.setName("Inna");
        m1.setNumberOfSubordinates(2);

        Manager m2 = new Manager();
        m2.setName("Petr");
        m2.setNumberOfSubordinates(1);

        Director d = new Director();
        d.setName("Alex");
        d.setNumberOfSubordinates(5);

        Employee[] employees = new Employee[]{w1, w2, w3, m1, m2, d};

        System.out.println(Utils.findEmployee("Sergv", employees));

    }

}
