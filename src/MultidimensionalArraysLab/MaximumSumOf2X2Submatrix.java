package MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2X2Submatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] input = readArray(sc.nextLine(), ", ");
        int row = input[0];
        int col = input[0];

        int[][] matrix = getMatrix(row, col, sc);
        getBestSum(matrix);

    }

    private static void getBestSum(int[][] matrix) {
        int bestSum = 0;
        int bestRow = 0;
        int bestCol = 0;
        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int sum = matrix[row][col] + matrix[row + 1][col]
                        + matrix[row][col + 1] + matrix[row + 1][col + 1];
                if(bestSum < sum){
                    bestSum = sum;
                    bestRow = row;
                    bestCol = col;
                }
            }
        }
        System.out.println(matrix[bestRow][bestCol] + " " + matrix[bestRow][bestCol + 1]);
        System.out.println(matrix[bestRow + 1][bestCol] + " " + matrix[bestRow + 1][bestCol + 1]);
        System.out.println(bestSum);
    }

    private static int[][] getMatrix(int rows, int cols, Scanner sc) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            matrix[i] = readArray(sc.nextLine(), ", ");
        }
        return matrix;
    }

    private static int[] readArray(String nextLine, String st) {
        return Arrays.stream(nextLine.split(st))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
