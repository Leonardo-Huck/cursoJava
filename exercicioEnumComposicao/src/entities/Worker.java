package entities;

import entities.enums.WorkerLevel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Worker {
    private String name;
    private Double baseSalary;
    private WorkerLevel level;

    private Department department;
    private List<HourContract> contracts = new ArrayList<>();

    public Worker() {
    }

    public Worker(String name, Double baseSalary, WorkerLevel level, Department department) {
        this.name = name;
        this.baseSalary = baseSalary;
        this.level = level;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<HourContract> getContracts() {
        return contracts;
    }


    public void addContract(HourContract contract) {
        contracts.add(contract);
    }

    public void removeContract(HourContract contract) {
        contracts.remove(contract);
    }

    public double income(int year, int month){
        double sum = getBaseSalary();
        Calendar calendar = Calendar.getInstance();

        for (HourContract contract : contracts) {
            calendar.setTime(contract.getDate());
            int contractMonth = calendar.get(Calendar.MONTH) + 1;
            int contractYear = calendar.get(Calendar.YEAR);
            if (contractYear == year && contractMonth == month){
                sum += contract.totalValue();
            }
        }
        return sum;
    }
}
