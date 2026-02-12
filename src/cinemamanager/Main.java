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

        Cinema cinema1 = new Cinema(2);
        Room room1 = new Room(rows, seatsPerRows);
        cinema1.addRoom(room1);


        cinema1.showRooms();
        System.out.printf("Total income:%n$%.2f%n", cinema1.calculateTotalIncome());


    }
}
