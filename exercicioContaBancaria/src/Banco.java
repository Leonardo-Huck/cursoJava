import entiti.ContaBancaria;

import java.util.Scanner;

public class Banco {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter account number: ");
        String numero = scanner.nextLine();
        System.out.println("Enter account holder: ");
        String nomeTitular = scanner.nextLine();
        System.out.println("Is there initial deposit (y/n)? ");
        char flag = scanner.nextLine().charAt(0);

        double saldo = 0;
        if(flag == 'y' || flag == 'Y') {
            System.out.println("Enter initial deposit amount: ");
            saldo = scanner.nextDouble();
        }

        ContaBancaria conta = new ContaBancaria(numero, nomeTitular, saldo);
        System.out.println(conta.toString());

        System.out.println("Enter deposit amount: ");
        double valor = scanner.nextDouble();
        conta.depositar(valor);
        System.out.println("Updated account data: ");
        System.out.println(conta.toString());

        System.out.println("Enter withdrawal amount: ");
        valor = scanner.nextDouble();
        conta.sacar(valor);
        System.out.println("Updated account data: ");
        System.out.println(conta.toString());

        scanner.close();
    }
}
