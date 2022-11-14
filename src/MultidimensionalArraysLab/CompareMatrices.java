package MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] input = readArray(sc.nextLine());
        int rows = input[0];
        int cols = input[1];
        int[][] firstMatrix = getMatrix(rows, cols, sc);

        int[] input2 = readArray(sc.nextLine());
        rows = input2[0];
        cols = input2[1];
        int[][] secondMatrix = getMatrix(rows, cols, sc);

        if(matricesAreEqual(firstMatrix, secondMatrix)){
            System.out.println("equal");
        }else{
            System.out.println("not equal");
        }
    }

    private static boolean matricesAreEqual(int[][] firstMatrix, int[][] secondMatrix) {
        if(firstMatrix.length != secondMatrix.length){
            return false;
        }

        for (int row = 0; row < firstMatrix.length; row++) {
            int[] firstArray = firstMatrix[row];
            int[] secondArray = secondMatrix[row];
            if(firstArray.length != secondArray.length){
                return false;
            }
            for (int col = 0; col < firstArray.length; col++) {
                if(firstArray[col] != secondArray[col]){
                    return false;
                }
            }
        }
        return true;
    }

    private static int[][] getMatrix(int rows, int cols, Scanner sc) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            matrix[i] = readArray(sc.nextLine());
        }
        return matrix;
    }

    private static int[] readArray(String nextLine) {
        return Arrays.stream(nextLine.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
