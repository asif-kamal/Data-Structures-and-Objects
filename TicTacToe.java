import java.util.Arrays;

public class TicTacToe {
    private char[][] board;
    private boolean isXTurn;

    public TicTacToe(char[][] board) {
        this.board = board;
        this.board = new char[][] { {'-','-','-'}, {'-','-','-'}, {'-','-','-'} };
    
    }

    public void move() {
        if(isXTurn) {
            
        }
    }

    public void displayTheBoard() {
        for (int index = 0; index < this.board.length; index++) {
            for (int i = 0; i < this.board[index].length; i++) {
                System.out.print(this.board[index][i] + " ");
            }
            System.out.println();
        }
        // System.out.println(Arrays.deepToString(this.board));
    } 

    public void isWhoseTurn() {
        if(isXTurn) {
            System.out.println("X");
        } else {
            System.out.println("O");
        }
    }

    public void detectIfWinner() {
        
    }

    public void winner() {

    }




}
