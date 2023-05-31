public class RoomDriver {

    public static void main(String[] args) {
        Room r1 = new Room();
        Room r2 = new Room();

        r1.addOneToRoom();
        r1.removeOneFromRoom();
        r1.addOneToRoom();

        r2.addOneToRoom();
        r2.addOneToRoom();
        r2.addOneToRoom();
        r2.addOneToRoom();
        r2.removeOneFromRoom();

        r1.getNumber();
        r2.getNumber();

        Room.getTotal();

    }
}
