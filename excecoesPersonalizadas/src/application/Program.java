package application;

import model.entities.Reservation;
import model.exceptions.DomainException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            System.out.print("Room number: ");
            int number = scanner.nextInt();
            System.out.print("Check-in date (DD/MM/YYYY): ");
            LocalDate checkIn = LocalDate.parse(scanner.next(), formatter);
            System.out.print("Check-out date (DD/MM/YYYY): ");
            LocalDate checkOut = LocalDate.parse(scanner.next(), formatter);

            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation:");
            System.out.print("Check-in date (DD/MM/YYYY): ");
            checkIn = LocalDate.parse(scanner.next(), formatter);
            System.out.print("Check-out date (DD/MM/YYYY): ");
            checkOut = LocalDate.parse(scanner.next(), formatter);

            reservation.updateDates(checkIn, checkOut);
            System.out.println("Reservation: " + reservation);
        } catch (DateTimeParseException e){
            System.out.println("Invalid date format");
        } catch (DomainException e){
            System.out.println("Error in reservation: " + e.getMessage());
        } catch (RuntimeException e){
            System.out.println("Unexpected error");
        }
        scanner.close();
    }
}
