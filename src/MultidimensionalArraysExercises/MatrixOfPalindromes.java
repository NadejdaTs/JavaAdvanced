package MultidimensionalArraysExercises;

import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        sc.nextLine();

        String[][] matrix = new String[rows][cols];
        char element = 'a';
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                String currElement = "" + element + (char)(element + col) + element;
                matrix[row][col] = currElement;
            }
            element++;
            element = (char)element;
        }
        printElementOfTheMatrix(matrix, rows, cols);
    }

    private static void printElementOfTheMatrix(String[][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
