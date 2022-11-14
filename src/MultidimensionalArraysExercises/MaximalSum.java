package MultidimensionalArraysExercises;

import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        sc.nextLine();

        int[][] matrix = new int[rows][cols];
        readMatrix(sc, rows, cols, matrix);
        printSquareMatrix( matrix);

    }

    private static void printSquareMatrix(int[][] matrix) {
        int maxSum = Integer.MIN_VALUE;
        int bestRow = 0;
        int bestCol = 0;
        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[0].length - 2; col++) {
                int sum = 0;
                sum += matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2];
                sum += matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2];
                sum += matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];

                if(sum > maxSum){
                    maxSum = sum;
                    bestRow = row;
                    bestCol = col;
                }
            }
        }

        System.out.println("Sum = " + maxSum);
        for (int i = bestRow; i < bestRow + 3; i++) {
            for (int j = bestCol; j < bestCol + 3; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void readMatrix(Scanner sc, int rows, int cols, int[][] matrix) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = sc.nextInt();
            }
            sc.nextLine();
        }
    }
}
