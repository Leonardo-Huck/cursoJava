package application;

import entities.Employee;
import entities.OutsourcedEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        List<Employee> list = new ArrayList<>();

        System.out.print("Enter the number of employees: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++){
            System.out.println("Employee #" + (i + 1) + " data:");
            System.out.print("Outsourced? (y/n) ");
            char answer = scanner.next().charAt(0);
            System.out.print("Name: ");
            scanner.nextLine();
            String name = scanner.nextLine();
            System.out.print("Hours: ");
            int hours = scanner.nextInt();
            System.out.print("Value per hour: ");
            double valuePerHour = scanner.nextDouble();

            if (answer == 'y'){
                System.out.print("Additional charge: ");
                double charge = scanner.nextDouble();
                list.add(new OutsourcedEmployee(name, hours, valuePerHour, charge));
            }else {
                list.add(new Employee(name, hours, valuePerHour));
            }
        }

        System.out.println();
        System.out.println("PAYMENTS:");
        for (Employee e : list){
            System.out.println(e.getName() + " - $ " + String.format("%.2f", e.payment()));
        }

        scanner.close();
    }
}
