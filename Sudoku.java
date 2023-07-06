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
            sum += (100 * board[0][0] + 10 * board[0][1] + board[0][2]);// sum up top leftmost 3 digit numbers of each
                                                                        // solution
            return true;
        }
        if (board[row][col] != 0) {
            return solveSudoku(board, row, col + 1); // had to return method instead of just running the method
        }
        for (int i = 1; i <= board.length; i++) {
            if (isValid(board, row, col, i)) {
                board[row][col] = i;
                if (solveSudoku(board, row, col + 1)) {
                    return true;
                }
                board[row][col] = 0;// needed to add to reset square if false
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
        int subGridRow = (row / 3) * 3;// to figure out which subgrid the row is in
        int subGridCol = (col / 3) * 3;// to figure out which subgrid the column is in

        for (int j = 0; j < 3; j++) {// for j, iterate from 0 to 2
            for (int k = 0; k < 3; k++) {// for k, iterate from 0 to 2
                if (board[subGridRow + j][subGridCol + k] == i) {// check if board position equals i
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

            for (int i = 0; i < 50; i++) {// iterates over all 50 puzzles
                s.nextLine(); // consume empty line
                int[][] result = new int[9][9]; // create new 9x9 array of arrays
                for (int j = 0; j < 9; j++) {// iterate over each row as j
                    String n = s.nextLine();// assign nextLine() to variable n
                    char[] nn = n.toCharArray();// convert string to char array and assign to nn
                    for (int k = 0; k < 9; k++) { // iterate over col as k from 0 to 8
                        result[j][k] = nn[k] - '0';// converts char to integer and assigns integer to position
                                                   // result[j][k]
                    }
                }
                solveSudoku(result, 0, 0); // all 50 puzzles are solved when using scanner but not when using single
                                           // grids
            }
            System.out.println(Sudoku.sum);// prints sum variable of Sudoku class

        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
    }

}