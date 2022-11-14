package MultidimensionalArraysExercises;

import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        //sc.nextLine();

        int[][] matrix = new int[n][n];
        readMatrix(sc, matrix, n);
        int primarySum = getPrimaryDiagonal(matrix, n);
        int secondarySum = getSecondaryDiagonal(matrix, n);

        System.out.println(Math.abs(primarySum - secondarySum));
    }

    private static int getSecondaryDiagonal(int[][] matrix, int n) {
        int sum = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if(col == n - row - 1){
                    sum += matrix[row][col];
                }
            }
        }
        return sum;
    }

    private static int getPrimaryDiagonal(int[][] matrix, int n) {
        int sum = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if(row == col){
                    sum += matrix[row][col];
                }
            }
        }
        return sum;
    }

    private static void readMatrix(Scanner sc, int[][] matrix, int n) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                matrix[row][col] = sc.nextInt();
            }
            sc.nextLine();
        }
    }
}
