import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Sudoku {

    private static int sum = 0;

    public static boolean solveSudoku(int[][] board, int row, int col) {

        if (col == board.length) {
            row++;
            col = 0;
        }
        if (row == board.length) {
            for (int[] rowN : board) {
                System.out.println(Arrays.toString(rowN));
            }
            System.out.println();
            sum += (100*board[0][0] + 10*board[0][1] + board[0][2]);
            return true;
        }
        if (board[row][col] != 0) {
            return solveSudoku(board, row, col + 1);
        }
        for (int i = 1; i <= board.length; i++) {
            if (isValid(board, row, col, i)) {
                board[row][col] = i;
                if (solveSudoku(board, row, col + 1)) {
                    return true;
                }
                board[row][col] = 0;
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
        int subGridRow = (row / 3) * 3;
        int subGridCol = (col / 3) * 3;

        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 3; k++) {
                if (board[subGridRow + j][subGridCol + k] == i) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // int[][] board = new int[9][9];

        try {
            Scanner s = new Scanner(new File("p096_sudoku.txt"));

            for (int i = 0; i < 50; i++) {
                s.nextLine();
                int[][] result = new int[9][9];
                for (int j = 0; j < 9; j++) {
                    String n = s.nextLine();
                    char[] nn = n.toCharArray();
                    for (int k = 0; k < 9; k++) {
                        result[j][k] = nn[k] - '0';
                    }
                }
                solveSudoku(result, 0, 0);
            }
            System.out.println(Sudoku.sum);

        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
    }


}