package MultidimensionalArraysLab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] input = readArray(sc.nextLine());
        int rows = input[0];
        int cols = input[1];

        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            matrix[i] = readArray(sc.nextLine());
        }
        int n = Integer.parseInt(sc.nextLine());
        List<int[]> output = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col] == n){
                    output.add(new int[] {row, col});
                }
            }
        }
        if(output.isEmpty()){
            System.out.println("not found");
        }else{
            for (int[] element : output) {
                System.out.println(element[0] + " " + element[1]);
            }
        }
    }
    private static int[] readArray(String nextLine) {
        return Arrays.stream(nextLine.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
