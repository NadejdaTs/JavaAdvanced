package MultidimensionalArraysLab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FindTheRealQueen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 8;
        char[][] matrix = getMatrix(n, sc);
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col] == 'q'){
                    if(checkCurrentRow(matrix, row)){
                        if(checkCurrentCol(matrix, row, col)){
                            if(checkFirstDiagonal(matrix, row, col)){
                                if(checkSecondDiagonal(matrix, row, col)){
                                    System.out.println(row + " " + col);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static boolean checkFirstDiagonal(char[][] matrix, int row, int col) {
        int count = 0;
        for (int i = 1; i < matrix.length; i++) {
            if(isInBounds(row + i, col + i, matrix)){
                if(matrix[row + i][col + i] == 'q'){
                    count++;
                }
            }
            if(isInBounds(row - i, col - i, matrix)){
                if(matrix[row - i][col - i] == 'q') {
                    count++;
                }
            }
        }
        if(count >= 1){
            return false;
        }
        return true;
    }
    private static boolean checkSecondDiagonal(char[][] matrix, int row, int col) {
        int count = 0;
        for (int i = 1; i < matrix.length; i++) {
            if(isInBounds(row - i, col + i, matrix)){
                if(matrix[row - i][col + i] == 'q'){
                    count++;
                }
            }
            if(isInBounds(row + i, col - i, matrix)){
                if(matrix[row + i][col - i] == 'q') {
                    count++;
                }
            }
        }
        if(count >= 1){
            return false;
        }
        return true;
    }
    private static boolean isInBounds(int row, int col, char[][] matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private static boolean checkCurrentCol(char[][] matrix, int row, int col) {
        int count = 0;
        for (int i = 0; i < matrix[row].length; i++) {
            if(matrix[i][col] == 'q'){
                count++;
            }
        }
        if(count > 1){
            return false;
        }
        return true;
    }

    private static boolean checkCurrentRow(char[][] matrix, int row) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            if(matrix[row][i] == 'q'){
                count++;
            }
        }
        if(count > 1){
            return false;
        }
        return true;
    }

    private static char[][] getMatrix(int n, Scanner sc) {
        char[][] result = new char[n][n];
        for (int i = 0; i < n; i++) {
            String[] currentRow = sc.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                result[i][j] = currentRow[j].charAt(0);
            }
        }
        return result;
    }
    private static void printMatrix(char[][] result) {
        for (int row = 0; row < result.length; row++) {
            for (int col = 0; col < result[row].length; col++) {
                System.out.print(result[row][col] + " ");
            }
            System.out.println();
        }
    }
}
