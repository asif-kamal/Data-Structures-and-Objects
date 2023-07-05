import java.util.Arrays;

public class Sudoku {

    public static boolean solveSudoku(int[][] board, int row, int col) {
        if (col == board.length) {
            row++;
            col = 0;
        }
        if (row == board.length) {
            return true;
        }
        if (board[row][col] != 0) {
            solveSudoku(board, row, col + 1);
        }
        for (int i = 1; i <= board.length; i++) {
            if (isValid(board, row, col, i)) {
                board[row][col] = i;
                if (solveSudoku(board, row, col + 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isValid(int[][] board, int row, int col, int i) {
        // how do I check for a number i if there is another in row?
        // is row valid?
        return isRowValid(board, row, col, i) &&
                isColValid(board, row, col, i) &&
                isBoxValid(board, row, col, i);
    }

    private static boolean isRowValid(int[][] board, int row, int col, int i) {
        for (int j = 0; j < board.length; j++) {
            if (board[row][j] == i) {
                return false;
            }
        }
        return true;
    }

    private static boolean isColValid(int[][] board, int row, int col, int i) {
        for (int k = 0; k < board.length; k++) {
            if (board[k][col] == i) {
                return false;
            }
        }
        return true;
    }

    private static boolean isBoxValid(int[][] board, int row, int col, int i) {
        // how to check the 3x3 box for duplicates?
        if (col != 1 || col != 2 || col != 4 || col != 5 || col != 7 || col != 8) {
            for (int j = 0; j < 3; j++) {
                // each 3x3 box starts from 0-2, 3-5, and 6-8
                // figure out how to check a 3x3 box
                if (board[row][j] == i || board[row + 1][j] == i || board[row + 2][j] == i) {
                    return false;
                }
            }
        } else if (col == 1 || col == 4 || col == 7) {
            // each 3x3 box starts from 0-2, 3-5, and 6-8
            // figure out how to check a 3x3 box
            if (board[row][col + 1] == i || board[row + 1][col + 1] == i || board[row + 2][col + 1] == i
                    || board[row][col - 1] == i || board[row + 1][col - 1] == i || board[row + 2][col - 1] == i) {
                return false;
            }
        } else if (col == 2 || col == 5 || col == 8) {
            if (board[row][col - 1] == i || board[row + 1][col - 1] == i || board[row + 2][col - 1] == i
                    || board[row][col - 2] == i || board[row + 1][col - 2] == i || board[row + 2][col - 2] == i) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // int[][] board = new int[9][9];
        int[][] board = {
                { 0, 0, 3, 0, 2, 0, 6, 0, 0 },
                { 9, 0, 0, 3, 0, 5, 0, 0, 1 },
                { 0, 0, 1, 8, 0, 6, 4, 0, 0 },
                { 0, 0, 8, 1, 0, 2, 9, 0, 0 },
                { 7, 0, 0, 0, 0, 0, 0, 0, 8 },
                { 0, 0, 6, 7, 0, 8, 2, 0, 0 },
                { 0, 0, 2, 6, 0, 9, 5, 0, 0 },
                { 8, 0, 0, 2, 0, 3, 0, 0, 9 },
                { 0, 0, 5, 0, 1, 0, 3, 0, 0 }
        };
        solveSudoku(board, 0, 0);
        for (int[] rowN : board) {
            System.out.println(Arrays.toString(rowN));
        }

    }

}
