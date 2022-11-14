package MultidimensionalArraysLab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[][] matrix = getMatrix(n, sc);
        int[] coordinates = readArray(sc.nextLine(), " ");
        int wrongElement = matrix[coordinates[0]][coordinates[1]];
        getNewMatrix(matrix, wrongElement);
    }

    private static void getNewMatrix(int[][] matrix, int wrongElement) {
        List<int[]> updatedMatrix = new ArrayList<>();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col] == wrongElement){
                    updatedMatrix.add(new int[]{row, col, getClosestItemSum(row, col, matrix, wrongElement)});
                }
            }
        }
        for (int[] values : updatedMatrix) {
            matrix[values[0]][values[1]] = values[2];
        }
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] result) {
        for (int row = 0; row < result.length; row++) {
            for (int col = 0; col < result[row].length; col++) {
                System.out.print(result[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int getClosestItemSum(int row, int col, int[][] matrix, int wrongElement) {
        int sum = 0;
        if(isInBounds(row - 1, col, matrix) && matrix[row - 1][col] != wrongElement){
            sum += matrix[row - 1][col];
        }
        if(isInBounds(row + 1, col, matrix) && matrix[row + 1][col] != wrongElement){
            sum += matrix[row + 1][col];
        }
        if(isInBounds(row, col - 1, matrix) && matrix[row][col - 1] != wrongElement){
            sum += matrix[row][col - 1];
        }
        if(isInBounds(row, col + 1, matrix) && matrix[row][col + 1] != wrongElement){
            sum += matrix[row][col + 1];
        }
        return sum;
    }

    private static boolean isInBounds(int row, int col, int[][] matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
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
