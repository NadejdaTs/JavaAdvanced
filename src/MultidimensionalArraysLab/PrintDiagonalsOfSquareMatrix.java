package MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n  = Integer.parseInt(sc.nextLine());

        int[][] matrix = getMatrix(n, sc);
        printFirstDiagonals(matrix);
        printSecondDiagonals(matrix);
    }

    private static void printSecondDiagonals(int[][] matrix) {
        for (int row = matrix.length - 1; row >=0; row--) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(row == col){
                    System.out.print(matrix[row][matrix.length - row - 1] + " ");
                }
            }
        }
    }

    private static void printFirstDiagonals(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(row == col){
                    System.out.print(matrix[row][col] + " ");
                }
            }
        }
        System.out.println();
    }

    private static int[][] getMatrix(int n, Scanner sc) {
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            result[i] = readArray(sc.nextLine(), " ");
        }

        return result;
    }

    private static int[] readArray(String nextLine, String st){
        return Arrays.stream(nextLine.split(st))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
