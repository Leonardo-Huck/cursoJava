package application;

import model.entities.Account;
import model.exceptions.DomainException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter account data");
            System.out.print("Number: ");
            Integer number = scanner.nextInt();
            System.out.print("Holder: ");
            scanner.nextLine();
            String holder = scanner.nextLine();
            System.out.print("Initial balance: ");
            Double balance = scanner.nextDouble();
            System.out.print("Withdraw limit: ");
            Double withdrawLimit = scanner.nextDouble();

            Account account = new Account(number, holder, balance, withdrawLimit);

            System.out.println();
            System.out.print("Enter amount for withdraw: ");
            Double amount = scanner.nextDouble();

            account.withdraw(amount);
            System.out.println("New balance: " + account.getBalance());
        }
        catch (DomainException e){
            System.out.println("Withdraw error: " + e.getMessage());
        }
        catch (InputMismatchException e){
            System.out.println("Verifique os dados digitados");
        }
        catch (RuntimeException e){
            System.out.println("Erro inesperado: " + e.getMessage());
        }

        scanner.close();
    }
}
