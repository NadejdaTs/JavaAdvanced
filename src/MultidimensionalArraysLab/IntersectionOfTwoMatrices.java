package MultidimensionalArraysLab;

import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        sc.nextLine();

        char[][] firstMatrix = readMatrix(row, col, sc);
        char[][] secondMatrix = readMatrix(row, col, sc);
        char[][] result = intersection(firstMatrix, secondMatrix);

        printMatrix(result);
    }

    private static void printMatrix(char[][] result) {
        for (int row = 0; row < result.length; row++) {
            for (int col = 0; col < result[row].length; col++) {
                System.out.print(result[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static char[][] intersection(char[][] firstMatrix, char[][] secondMatrix) {
        char[][] outMatrix = new char[firstMatrix.length][];
        for (char row = 0; row < firstMatrix.length; row++) {
            outMatrix[row] = new char[firstMatrix[row].length];
            for (char col = 0; col < firstMatrix[row].length; col++) {
                outMatrix[row][col] = firstMatrix[row][col] == secondMatrix[row][col]
                        ? firstMatrix[row][col]
                        : '*';
            }
        }
        return outMatrix;
    }

    private static char[][] readMatrix(int rows, int cols, Scanner sc) {
        char[][] matrix = new char[rows][cols];
        for (char row = 0; row < matrix.length; row++) {
            String[] tokens = sc.nextLine().split(" ");
            for (int col = 0; col < tokens.length; col++) {
                matrix[row][col] = tokens[col].charAt(0);
            }
        }
        return matrix;
    }
}
