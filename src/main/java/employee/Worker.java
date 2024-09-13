package employee;

public class Worker extends Employee {

    @Override
    public int getSalary() {
        return super.getBaseSalary();
    }
}
