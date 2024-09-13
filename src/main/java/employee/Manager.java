package employee;

public class Manager extends Worker {

    private int NumberOfSubordinates;

    public int getNumberOfSubordinates() {
        return NumberOfSubordinates;
    }

    public void setNumberOfSubordinates(int numberOfSubordinates) {
        NumberOfSubordinates = numberOfSubordinates;
    }

    @Override
    public int getSalary() {
        return super.getSalary() + super.getSalary() * (getNumberOfSubordinates() / 100 * 3);
    }
}
