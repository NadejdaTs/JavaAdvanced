package MultidimensionalArraysExercises;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class RadioactiveMutantVampireBunnies {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        char[][] matrix = readMatrix(n, m, sc);
        ArrayDeque<Integer> bunniesList = new ArrayDeque<>();
        int[] playerWin = new int[2];
        String input = sc.nextLine();
        boolean isPlayerWin = false;
        boolean isPlayerFindBunny = false;
        for (int i = 0; i < input.length(); i++) {
            boolean isPlayerMoved = false;
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < m; col++) {
                    if(matrix[row][col] == 'P' && !isPlayerMoved){
                        switch(input.charAt(i)){
                            case 'U':
                                if(!checkIsInBounds(matrix, row - 1, col)) {
                                    isPlayerWin = true;
                                    playerWin[0] = row;
                                    playerWin[1] = col;
                                }else if(matrix[row - 1][col] == 'B'){
                                    isPlayerFindBunny = true;
                                    playerWin[0] = row - 1;
                                    playerWin[1] = col;
                                }else{
                                    matrix[row - 1][col] = 'P';
                                    isPlayerMoved = true;
                                }
                                break;
                            case 'D':
                                if(!checkIsInBounds(matrix, row + 1, col)) {
                                    isPlayerWin = true;
                                    playerWin[0] = row;
                                    playerWin[1] = col;
                                }else if(matrix[row + 1][col] == 'B'){
                                    isPlayerFindBunny = true;
                                    playerWin[0] = row + 1;
                                    playerWin[1] = col;
                                } else {
                                    matrix[row + 1][col] = 'P';
                                    isPlayerMoved = true;
                                }
                                break;
                            case 'L':
                                if(!checkIsInBounds(matrix, row, col - 1)) {
                                    isPlayerWin = true;
                                    playerWin[0] = row;
                                    playerWin[1] = col;
                                }else if(matrix[row][col - 1] == 'B'){
                                    isPlayerFindBunny = true;
                                    playerWin[0] = row;
                                    playerWin[1] = col - 1;
                                }else{
                                    matrix[row][col - 1] = 'P';
                                    isPlayerMoved = true;
                                }
                                break;
                            case 'R':
                                if(!checkIsInBounds(matrix, row, col + 1)) {
                                    isPlayerWin = true;
                                    playerWin[0] = row;
                                    playerWin[1] = col;
                                }else if(matrix[row][col + 1] == 'B'){
                                    isPlayerFindBunny = true;
                                    playerWin[0] = row;
                                    playerWin[1] = col + 1;
                                }else{
                                    matrix[row][col + 1] = 'P';
                                    isPlayerMoved = true;
                                }
                                break;
                        }
                        matrix[row][col] = '.';
                    }else if(matrix[row][col] == 'B'){
                        bunniesList.offer(row);
                        bunniesList.offer(col);
                    }
                }
            }
            if(activateBunnies(matrix, bunniesList, playerWin) || isPlayerFindBunny){
                printMatrix(matrix);
                System.out.printf("dead: %d %d%n", playerWin[0], playerWin[1]);
                return;
            }
            if(isPlayerWin){
                printMatrix(matrix);
                System.out.printf("won: %d %d%n", playerWin[0], playerWin[1]);
                return;
            }
        }
    }

    private static boolean activateBunnies(char[][] matrix, ArrayDeque<Integer> bunniesList, int[] playerWin) {
        boolean isDead = false;
        int initialBunnySize = bunniesList.size() / 2;
        for (int i = 0; i < initialBunnySize; i++) {
            int row = bunniesList.poll();
            int col = bunniesList.poll();
            if(checkBunny(matrix, row - 1, col)){
                isDead = true;
                playerWin[0] = row - 1;
                playerWin[1] = col;
            }else if(checkBunny(matrix, row + 1, col)){
                isDead = true;
                playerWin[0] = row + 1;
                playerWin[1] = col;
            }else if(checkBunny(matrix, row, col - 1)){
                isDead = true;
                playerWin[0] = row;
                playerWin[1] = col - 1;
            }else if(checkBunny(matrix, row, col + 1)){
                isDead = true;
                playerWin[0] = row;
                playerWin[1] = col + 1;
            }
        }
        return isDead;
    }

    private static boolean checkBunny(char[][] matrix, int row, int col) {
        if(checkIsInBounds(matrix, row, col)){
            if(matrix[row][col] == 'P'){
                matrix[row][col] = 'B';
                return true;
            }
            matrix[row][col] = 'B';
        }
        return false;
    }

    private static boolean checkIsInBounds(char[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private static char[][] readMatrix(int rows, int cols, Scanner sc) {
        char[][] matrix = new char[rows][cols];
        for (char row = 0; row < matrix.length; row++) {
            String[] tokens = sc.nextLine().split("");
            for (int col = 0; col < tokens.length; col++) {
                matrix[row][col] = tokens[col].charAt(0);
            }
        }
        return matrix;
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
