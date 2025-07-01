package application;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Enter client data: ");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        LocalDate birthday = LocalDate.parse(scanner.next(), formatter);

        Client client = new Client(name, email, birthday);

        System.out.println("Enter order data: ");
        System.out.print("Status: ");
        scanner.nextLine();
        String status = scanner.nextLine();

        Order order = new Order(LocalDateTime.now(), OrderStatus.valueOf(status), client);

        System.out.print("How many items to this order? ");
        int quantity = scanner.nextInt();

        for (int i = 0; i < quantity; i++) {
            System.out.println("Enter #" + (i + 1) + " item data: ");
            System.out.print("Product name: ");
            scanner.nextLine();
            String productName = scanner.nextLine();
            System.out.print("Product price: ");
            double productPrice = scanner.nextDouble();
            System.out.print("Quantity: ");
            int productQuantity = scanner.nextInt();
            order.addItem(new OrderItem(productQuantity, productPrice, new Product(productName, productPrice)));
        }

        System.out.println();

        System.out.println(order);
    }
}
