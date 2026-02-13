package cinemamanager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Stage 2
        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of seats in each row: ");
        int seatsPerRows = scanner.nextInt();

        System.out.println();

        Cinema cinema1 = new Cinema(2);
        Room room1 = new Room(rows, seatsPerRows);
        cinema1.addRoom(room1);

        cinema1.showRoom(room1);

        System.out.println("Enter a row number:");
        int rowNumber = scanner.nextInt();
        System.out.println("Enter a seat number in that row: ");
        int seatNumber = scanner.nextInt();

        System.out.println();


        try {
            double ticketPrice = cinema1.buyTicket(room1, rowNumber, seatNumber);
            System.out.printf("Ticket price: %.2f%n%n", ticketPrice);

            cinema1.showRoom(room1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }



        //System.out.printf("Total income:%n$%.2f%n", cinema1.calculateTotalIncome());


    }
}
