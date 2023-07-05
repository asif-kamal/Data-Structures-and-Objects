import java.util.Arrays;

public class EightQueens {

    public static boolean eightQueens(int[][] board, int col) {
        if (col >= board.length) {
            for (int[] rowN : board) {
                System.out.println(Arrays.toString(rowN));
            }
            return true;
        }

        for (int i = 0; i < board.length; i++) {
            if (isValid(board, i, col)) {
                board[i][col] = 1;
                if (eightQueens(board, col + 1)) {
                    return true;
                }
            }
            board[i][col] = 0;
        }
        return false;
    }

    public static boolean isValid(int[][] board, int row, int col) {

        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        for (int i = row, j = col; i < board.length && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] board = new int[8][8];
        int col = 0;
        System.out.println(eightQueens(board, col));
    }
}
