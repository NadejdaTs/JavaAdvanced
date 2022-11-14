package MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] sizes = readArray(sc.nextLine());

        int rows = sizes[0];
        int cols = sizes[1];
        int[][] matrix = getMatrix(rows, cols, sc);

        System.out.println(matrix.length); //rows
        System.out.println(matrix[0].length); //cols
        System.out.println(getSumOfElements(matrix));
    }

    private static int getSumOfElements(int[][] matrix) {
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                sum += matrix[row][col];
            }
        }
        return sum;
    }

    private static int[][] getMatrix(int rows, int cols, Scanner sc) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            matrix[i] = readArray(sc.nextLine());
        }
        return matrix;
    }

    private static int[] readArray(String nextLine) {
        return Arrays.stream(nextLine.split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
