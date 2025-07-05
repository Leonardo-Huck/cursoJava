package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        List<Product> products = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int numberOfProducts = scanner.nextInt();

        for (int i = 0; i < numberOfProducts; i++) {
            System.out.println("Product #" + (i+1) + " data: ");
            System.out.print("Common, used or imported (c/u/i)? ");
            char choice = scanner.next().charAt(0);
            System.out.print("Name: ");
            scanner.nextLine();
            String name = scanner.nextLine();
            System.out.print("Price: ");
            Double price = scanner.nextDouble();

            switch (choice) {
                case 'c' -> products.add(new Product(name, price));
                case 'i' -> {
                    System.out.print("Customs fee: ");
                    double customsFee = scanner.nextDouble();
                    products.add(new ImportedProduct(name, price, customsFee));
                }
                case 'u' -> {
                    System.out.print("Manufacture date (DD/MM/YYYY): ");
                    LocalDate date = LocalDate.parse(scanner.next(), formatter);
                    products.add(new UsedProduct(name, price, date));
                }
                default -> System.out.println("Invalid choice.");
            }
        }

        System.out.println();
        System.out.println("PRICE TAGS: ");

        for (Product product : products) {
            System.out.println(product.priceTag());
        }

        scanner.close();
    }
}
