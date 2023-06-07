public class Rabbit extends Animal {

  // private boolean canSeeFoxNow = false;
  // private int distanceToFox;
  private int directionToFox;
  // private int currentDirection;

  public Rabbit(Model model, int row, int column) {
    super(model, row, column);
  }

  int decideMove() {

    for (int i = Model.MIN_DIRECTION; i <= Model.MAX_DIRECTION; i++) {

      if (look(i) == Model.FOX) {
        // canSeeFoxNow = true;
        directionToFox = i;
        // distanceToFox = distance(i);
        // if (canSeeFoxNow) {
        if (canMove(Model.turn(directionToFox, -3))) { // Direction is:
          return Model.turn(directionToFox, -3); // SW
        } else if (canMove(Model.turn(directionToFox, -5))) { // SE
          return Model.turn(directionToFox, -5);
        } else if (canMove(Model.turn(directionToFox, -4))) { // S
          return Model.turn(directionToFox, -4);
        } else if (canMove(Model.turn(directionToFox, -2))) { // W
          return Model.turn(directionToFox, -2);
        } else if (canMove(Model.turn(directionToFox, -6))) { // E
          return Model.turn(directionToFox, -6);
        } else if (canMove(Model.turn(directionToFox, -1))) { // NW
          return Model.turn(directionToFox, -1);
        } else if (canMove(Model.turn(directionToFox, -7))) { // NE
          return Model.turn(directionToFox, -7);
        }

        else {
          // canSeeFoxNow = false;
          return Model.STAY;
        }
      }

    }

    return Model.STAY;

  }
}