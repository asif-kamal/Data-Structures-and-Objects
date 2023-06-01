public class TicTacToeDriver {

    public static void main(String[] args) {

        TicTacToe t1 = new TicTacToe(new char[0][0]); //use 'new' keyword inside parameters to initialize new char array

        // t1.displayTheBoard();
        // t1.isWhoseTurn();
        t1.move(0, 0);//(2,2) does not work
        t1.displayTheBoard();
        t1.isWhoseTurn();
        t1.move(0,2);
        t1.displayTheBoard();
        t1.move(1, 0);
        t1.displayTheBoard();
        t1.move(1,2);
        t1.displayTheBoard();
        t1.move(2,0);
        t1.displayTheBoard();
        t1.detectIfWinner();
        t1.winner();
        t1.restartGame();
        t1.displayTheBoard();
        
    }
    
}
