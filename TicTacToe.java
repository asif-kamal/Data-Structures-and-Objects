public class TicTacToe {
    private char[][] board;
    private boolean isXTurn;

    public TicTacToe(char[][] board) {
        this.board = board;
        this.board = new char[][] { { '-', '-', '-' }, { '-', '-', '-' }, { '-', '-', '-' } }; // single quotes for char
                                                                                               // array

    }

    public void move(int row, int col) {
        if (isXTurn) {
            if (this.board[row][col] == '-') {
                this.board[row][col] = 'X';
                isXTurn = false;
            }
        } else {
            if (this.board[row][col] == '-') {
                this.board[row][col] = 'O';
                isXTurn = true;
            }
        }
    }

    public void displayTheBoard() {
        for (int index = 0; index < this.board.length; index++) { //the first row is at the top of the matrix
            for (int i = 0; i < this.board[index].length; i++) {
                System.out.print(this.board[index][i] + " ");
            }
            System.out.println();
        }
        // System.out.println(Arrays.deepToString(this.board));
    }

    public void isWhoseTurn() {
        if (isXTurn) {
            System.out.println("X");
        } else {
            System.out.println("O");
        }
    }

    public char detectIfWinner() {
        if ((this.board[0][0] == 'O') && (this.board[0][1] == 'O') && (this.board[0][2] == 'O')) {
            char win = 'O';
            System.out.println("There's a winner!");
            return win;
        } else if ((this.board[1][0] == 'O') && (this.board[1][1] == 'O') && (this.board[1][2] == 'O')) {
            char win = 'O';
            System.out.println("There's a winner!");
            return win;
        } else if ((this.board[2][0] == 'O') && (this.board[2][1] == 'O') && (this.board[2][2] == 'O')) {
            char win = 'O';
            System.out.println("There's a winner!");
            return win;
        } else if ((this.board[0][0] == 'O') && (this.board[1][0] == 'O') && (this.board[2][0] == 'O')) {
            char win = 'O';
            System.out.println("There's a winner!");
            return win;
        } else if ((this.board[0][1] == 'O') && (this.board[1][1] == 'O') && (this.board[2][1] == 'O')) {
            char win = 'O';
            System.out.println("There's a winner!");
            return win;
        } else if ((this.board[0][2] == 'O') && (this.board[1][2] == 'O') && (this.board[2][2] == 'O')) {
            char win = 'O';
            System.out.println("There's a winner!");
            return win;
        } else if ((this.board[2][0] == 'O') && (this.board[1][1] == 'O') && (this.board[0][2] == 'O')) {
            char win = 'O';
            System.out.println("There's a winner!");
            return win;
        } else if ((this.board[2][2] == 'O') && (this.board[1][1] == 'O') && (this.board[0][0] == 'O')) {
            char win = 'O';
            System.out.println("There's a winner!");
            return win;
        } else if ((this.board[0][0] == 'X') && (this.board[0][1] == 'X') && (this.board[0][2] == 'X')) {
            char win = 'X';
            System.out.println("There's a winner!");
            return win;
        } else if ((this.board[1][0] == 'X') && (this.board[1][1] == 'X') && (this.board[1][2] == 'X')) {
            char win = 'X';
            System.out.println("There's a winner!");
            return win;
        } else if ((this.board[2][0] == 'X') && (this.board[2][1] == 'X') && (this.board[2][2] == 'X')) {
            char win = 'X';
            System.out.println("There's a winner!");
            return win;
        } else if ((this.board[0][0] == 'X') && (this.board[1][0] == 'X') && (this.board[2][0] == 'X')) {
            char win = 'X';
            System.out.println("There's a winner!");
            return win;
        } else if ((this.board[0][1] == 'X') && (this.board[1][1] == 'X') && (this.board[2][1] == 'X')) {
            char win = 'X';
            System.out.println("There's a winner!");
            return win;
        } else if ((this.board[0][2] == 'X') && (this.board[1][2] == 'X') && (this.board[2][2] == 'X')) {
            char win = 'X';
            System.out.println("There's a winner!");
            return win;
        } else if ((this.board[2][0] == 'X') && (this.board[1][1] == 'X') && (this.board[0][2] == 'X')) {
            char win = 'X';
            System.out.println("There's a winner!");
            return win;
        } else if ((this.board[2][2] == 'X') && (this.board[1][1] == 'X') && (this.board[0][0] == 'X')) {
            char win = 'X';
            System.out.println("There's a winner!");
            return win;
        } else {
            return '-';
        }
    }

    public void winner() {
        if (detectIfWinner() != '-') {
            System.out.println(detectIfWinner());
        }
    }

    public void restartGame() {
        this.board = new char[][] { { '-', '-', '-' }, { '-', '-', '-' }, { '-', '-', '-' } };
    }
}
