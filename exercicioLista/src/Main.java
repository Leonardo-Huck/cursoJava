import entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many employee will be registered? ");
        int numberOfEmployees = scanner.nextInt();

        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < numberOfEmployees; i++) {
            System.out.printf("\nEmployee #%d data:\n", i + 1);
            System.out.print("ID: ");
            String ID = scanner.next();
            System.out.print("Name: ");
            scanner.nextLine();
            String name = scanner.nextLine();
            System.out.print("Salary: ");
            Double salary = scanner.nextDouble();

            employees.add(new Employee(ID, name, salary));
        }

        System.out.print("\nEnter the employee ID that will have salary increase: ");
        String ID = scanner.next();

        if (employees.stream().noneMatch(employee -> employee.getID().equals(ID)))
            System.out.println("This ID does not exist!");

        for (Employee employee : employees) {
            if (employee.getID().equals(ID)) {
                System.out.print("Enter the percentage: ");
                Double percentage = scanner.nextDouble();
                employee.setSalary(employee.getSalary() + (employee.getSalary() * (percentage / 100)));
                break;
            }
        }

        System.out.println("\nList of employees:");
        for (Employee employee : employees) {
            System.out.printf(employee.toString());
        }


    }
}