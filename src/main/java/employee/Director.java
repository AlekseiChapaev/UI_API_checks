package employee;

public class Director extends Worker {

    int numberOfSubordinates;

    public int getNumberOfSubordinates() {
        return numberOfSubordinates;
    }

    public void setNumberOfSubordinates(int numberOfSubordinates) {
        this.numberOfSubordinates = numberOfSubordinates;
    }

    @Override
    public int getSalary() {
        return super.getSalary() + super.getSalary() * (getNumberOfSubordinates() / 100 * 3);
    }
}
