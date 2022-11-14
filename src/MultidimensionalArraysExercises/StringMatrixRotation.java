package MultidimensionalArraysExercises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String rotationCommand = sc.nextLine();
        int rotation = Integer.parseInt(rotationCommand.substring(7, rotationCommand.length() - 1));

        String command = sc.nextLine();
        ArrayList<String> listOfElements = new ArrayList<>();
        while(!command.equals("END")){
            listOfElements.add(command);
            command = sc.nextLine();
        }

        int maxLengthOfElement = 0;
        for (int i = 0; i < listOfElements.size(); i++) {
            int currLengthOfElement = listOfElements.get(i).length();
            if(maxLengthOfElement < currLengthOfElement){
                maxLengthOfElement = currLengthOfElement;
            }
        }

        while (rotation >= 360){
            rotation = rotation % 360;
        }

        int rows = listOfElements.size();
        int cols = maxLengthOfElement;
        if(rotation == 0){
            char[][] resultMatrix = getMatrix(rows, cols, listOfElements);
            printMatrix(resultMatrix);
        }else if(rotation == 90){
            rows = maxLengthOfElement;
            cols = listOfElements.size();
            Collections.reverse(listOfElements);
            char[][] resultMatrix = getMatrix90(rows, cols, listOfElements);
            printMatrix(resultMatrix);
        }else if(rotation == 180){
            Collections.reverse(listOfElements);
            char[][] resultMatrix = getMatrix180(rows, cols, listOfElements);
            printMatrix(resultMatrix);
        }else if(rotation == 270){
            rows = maxLengthOfElement;
            cols = listOfElements.size();
            char[][] resultMatrix = getMatrix270(rows, cols, listOfElements);
            printMatrix(resultMatrix);
        }

    }

    private static char[][] getMatrix(int rows, int cols, ArrayList<String> listOfElements) {
        char[][] result = new char[rows][cols];
        for (char row = 0; row < result.length; row++) {
            String currRows = listOfElements.get(row);
            for (int col = 0; col < result[row].length; col++) {
                if(col < cols - (cols - currRows.length())){
                    result[row][col] = currRows.charAt(col);
                }else{
                    result[row][col] = ' ';
                }
            }
        }
        return result;
    }

    private static char[][] getMatrix90(int rows, int cols, ArrayList<String> listOfElements) {
        char[][] result = new char[rows][cols];
        for (int row = 0; row < cols; row++) {
            String currRows = listOfElements.get(row);
            for (int col = 0; col < result.length; col++) {
                if(col < result.length - (result.length - currRows.length())){
                    result[col][row] = currRows.charAt(col);
                }else{
                    result[col][row] = ' ';
                }
            }
        }
        return result;
    }

    private static char[][] getMatrix180(int rows, int cols, ArrayList<String> listOfElements) {
        char[][] result = new char[rows][cols];
        for (char row = 0; row < result.length; row++) {
            String currRows = listOfElements.get(row);
            for (int col = 0; col < result[row].length; col++) {
                if(col < cols - (cols - currRows.length())){
                    result[row][cols - 1 - col] = currRows.charAt(col);
                }else{
                    result[row][cols - 1 - col] = ' ';
                }
            }
        }
        return result;
    }

    private static char[][] getMatrix270(int rows, int cols, ArrayList<String> listOfElements) {
        char[][] result = new char[rows][cols];
        for (int row = 0; row < cols; row++) {
            String currRows = listOfElements.get(row);
            for (int col = 0; col < result.length; col++) {
                if(col < result.length - (result.length - currRows.length())){
                    result[result.length - 1 - col][row] = currRows.charAt(col);
                }else{
                    result[result.length - 1 - col][row] = ' ';
                }
            }
        }
        return result;
    }

    private static void printMatrix(char[][] result) {
        for (int row = 0; row < result.length; row++) {
            for (int col = 0; col < result[row].length; col++) {
                System.out.print(result[row][col]);
            }
            System.out.println();
        }
    }
}
