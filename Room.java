public class Room {
    private int numberInRoom = 0;
    private static int totalNumber = 0;


    public void addOneToRoom() {

        numberInRoom++;
        totalNumber++;
    }

    public void removeOneFromRoom() {
        if (numberInRoom > 0 && totalNumber > 0) {

            numberInRoom--;
            totalNumber--;
        }
    }

    public int getNumber() {
        //System.out.println(numberInRoom);
        return numberInRoom;
    }

    public static int getTotal() {
        //System.out.println(totalNumber);
        return totalNumber;
    }
}
