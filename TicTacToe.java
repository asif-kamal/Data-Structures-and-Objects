public class TicTacToe {
    private char[][] board;
    private boolean isXTurn;

    public TicTacToe(char[][] board) {
        this.board = board;
        this.board = new char[][] { {'-','-','-'}, {'-','-','-'}, {'-','-','-'} }; //single quotes for char array
    
    }

    public void move(int row, int col) {
        if(isXTurn) {
            this.board[row][col] = 'X';
            isXTurn = false;
        } else {
            this.board[row][col] = 'O';
            isXTurn = true;
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
