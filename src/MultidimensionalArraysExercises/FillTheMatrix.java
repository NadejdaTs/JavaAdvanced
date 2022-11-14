package MultidimensionalArraysExercises;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(", ");
        int matrixLength = Integer.parseInt(input[0]);
        String patternOfMatrix = input[1];

        int[][] matrix = new int[matrixLength][matrixLength];

        if(patternOfMatrix.equals("A")){
            getPatternA(matrix, matrixLength);
        }else if(patternOfMatrix.equals("B")){
            getPatternB(matrix, matrixLength);
        }

        printMatrix(matrix, matrixLength);
    }

    private static void printMatrix(int[][] matrix, int matrixLength) {
        for (int row = 0; row < matrixLength; row++) {
            for (int col = 0; col < matrixLength; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void getPatternB(int[][] matrix, int matrixLength) {
        int currNumber = 1;
        for (int col = 0; col < matrixLength; col++) {
            if(col % 2 == 0){
                for (int row = 0; row < matrixLength; row++) {
                    matrix[row][col] = currNumber++;
                }
            }else{
                for (int row = matrixLength - 1; row >= 0; row--) {
                    matrix[row][col] = currNumber++;
                }
            }
        }
    }

    private static void getPatternA(int[][] matrix, int matrixLength) {
        int currNumber = 1;
        for (int col = 0; col < matrixLength; col++) {
            for (int row = 0; row < matrixLength; row++) {
                matrix[row][col] = currNumber++;
            }
        }
    }
}
