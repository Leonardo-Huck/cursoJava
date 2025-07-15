package application;

import model.entities.Reservation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.print("Room number: ");
        int number = scanner.nextInt();
        System.out.print("Check-in date (DD/MM/YYYY): ");
        LocalDate checkIn = LocalDate.parse(scanner.next(), formatter);
        System.out.print("Check-out date (DD/MM/YYYY): ");
        LocalDate checkOut = LocalDate.parse(scanner.next(), formatter);

        if (!checkOut.isAfter(checkIn)){
            System.out.println("Error in reservation: Check-out must be after check-in date");
        }
        else {
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);


            System.out.println();
            System.out.println("Enter data to update the reservation:");
            System.out.print("Check-in date (DD/MM/YYYY): ");
            checkIn = LocalDate.parse(scanner.next(), formatter);
            System.out.print("Check-out date (DD/MM/YYYY): ");
            checkOut = LocalDate.parse(scanner.next(), formatter);

            String error = reservation.updateDates(checkIn, checkOut);

            if (error != null){
                System.out.println("Error in reservation: " + error);
            }else {
                System.out.println("Reservation: " + reservation);
            }
        }
        scanner.close();
    }
}
