package cinemamanager;

public class Room {
    private static int count;
    private int roomId;
    private int rows;
    private int seatsPerRow;
    private final int totalSeats;


    public Room(int rows, int seatsPerRow) {
        this.rows = rows;
        this.seatsPerRow = seatsPerRow;
        this.totalSeats = this.rows * this.seatsPerRow;
        count++;
        this.roomId = count;
    }

    public double calculateRoomIncome() {
        if (this.totalSeats <= 60) {
            return this.totalSeats * 10.0;
        } else {
            int frontSeats = (this.rows / 2) * this.seatsPerRow;
            int backSeats = this.totalSeats - frontSeats;

            return (frontSeats * 10.0) + (backSeats * 8.0);
        }
    }

    public void printSeats() {
        System.out.printf("Room %d:%n", roomId);
        System.out.printf("%2s", "");

        for (int i = 1; i <= seatsPerRow; i++) {
            System.out.printf("%2d ", i);
        }

        System.out.println();

        for (int i = 0; i < rows; i++) {
            System.out.printf("%-2d ", i + 1);
            for (int j = 0; j < seatsPerRow; j++) {
                System.out.printf("%-3s", "S");
            }
            System.out.println();
        }
    }
}
