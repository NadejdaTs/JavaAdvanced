package MultidimensionalArraysExercises;

import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        sc.nextLine();

        String[][] matrix = new String[rows][cols];
        getTheMatrix(matrix, rows, sc);

        String[] commands = sc.nextLine().split("\\s+");
        while(!commands[0].equals("END")){
            if(!checkForValidCoordinates(commands, rows, cols)){
                System.out.println("Invalid input!");
            }else {
                int row1 = Integer.parseInt(commands[1]);
                int col1 = Integer.parseInt(commands[2]);
                int row2 = Integer.parseInt(commands[3]);
                int col2 = Integer.parseInt(commands[4]);

                String element1 = matrix[row1][col1];
                String element2 = matrix[row2][col2];
                matrix[row1][col1] = element2;
                matrix[row2][col2] = element1;
                printElementOfTheMatrix(matrix, rows, cols);
            }

            commands = sc.nextLine().split("\\s+");
        }
    }

    private static boolean checkForValidCoordinates(String[] commands, int rows, int cols) {
        if(!commands[0].equals("swap")){
            return false;
        }

        if(commands.length != 5){
            return false;
        }

        int row1 = Integer.parseInt(commands[1]);
        int col1 = Integer.parseInt(commands[2]);
        int row2 = Integer.parseInt(commands[3]);
        int col2 = Integer.parseInt(commands[4]);

        if((row1 >= 0 && row1 <= rows) && (col1 >= 0 && col1 <= cols) && (row2 >= 0 && row2 <= rows) && (col2 >= 0 && col2 <= cols)){
            return true;
        }

        return false;
    }

    private static void getTheMatrix(String[][] matrix, int rows, Scanner sc) {
        for (int row = 0; row < rows; row++) {
            matrix[row] = sc.nextLine().split( "\\s+");
        }
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
