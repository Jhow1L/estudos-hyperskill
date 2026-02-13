package cinemamanager;

public class Room {
    private static int count;
    private int roomId;
    private int rows;
    private int seatsPerRow;
    private final int totalSeats;
    private char[][] seats;


    public Room(int rows, int seatsPerRow) {
        this.rows = rows;
        this.seatsPerRow = seatsPerRow;
        this.seats = new char[rows][seatsPerRow];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seatsPerRow; j++) {
                seats[i][j] = 'S';
            }
        }
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

    public double seatPrice(int row){
        if (this.totalSeats <= 60) {
            return 10.0;
        } else {
            int frontSeats = (this.rows / 2);

            if (row <= frontSeats){
                return 10.0;
            }
            else {
                return 8.0;
            }

        }
    }

    public void reserveSeat(int row, int seat) throws Exception{
        if (seats[row - 1][seat - 1] != 'B'){
            seats[row - 1][seat - 1] = 'B';
        }
        else {
            throw new Exception("This seat is unavailable.");
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
                System.out.printf("%-3s", seats[i][j]);
            }
            System.out.println();
        }
    }
}
