package entities;

public class Employee {
    private String ID;
    private String name;
    private Double salary;

    public Employee(String ID, String name, Double salary) {
        this.ID = ID;
        this.name = name;
        this.salary = salary;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %.2f\n", this.ID, this.name, this.salary);
    }
}
