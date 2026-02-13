package cinemamanager;

public class Cinema {
    private Room[] rooms;
    private int numberOfRooms;

    public Cinema() {
        this.rooms = new Room[0];
        this.numberOfRooms = 0;
    }

    public Cinema(int numberOfRooms){
        this.rooms = new Room[numberOfRooms];
        this.numberOfRooms = 0;
    }

    public void addRoom(Room room){
        increaseRooms();
        rooms[numberOfRooms] = room;
        this.numberOfRooms++;

    }

    public void showRooms(){
        for (int i = 0; i < numberOfRooms; i++){
            rooms[i].printSeats();
            System.out.println();
        }
    }

    public void showRoom(Room room){
        room.printSeats();
    }

    public double calculateTotalIncome(){
        double totalIncome = 0;
        for (int i = 0; i < numberOfRooms; i++){
            totalIncome += rooms[i].calculateRoomIncome();
        }
        return totalIncome;
    }

    private void increaseRooms(){
        if(rooms.length == 0){
            rooms = new Room[1];
        }
        else if (numberOfRooms == rooms.length){
            Room[] newRooms = new Room[numberOfRooms * 2];
            for(int i = 0; i < numberOfRooms; i++){
                newRooms[i] = rooms[i];
            }
            rooms = newRooms;
        }
    }

    public double buyTicket(Room room, int row, int seat) throws Exception{
        room.reserveSeat(row, seat);
        return room.seatPrice(row);
    }



}
