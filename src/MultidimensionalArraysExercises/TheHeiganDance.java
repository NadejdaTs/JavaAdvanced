package MultidimensionalArraysExercises;

import java.util.List;
import java.util.Scanner;

public class TheHeiganDance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double damage = Double.parseDouble(sc.nextLine());
        double hsPoints= 3000000.0;
        int playerPoints = 18500;
        int playerRow = 7;
        int playerCol = 7;
        String lastSpell = "";
        boolean activeCloud = false;

        while(playerPoints > 0 && hsPoints > 0){
            String[] command = sc.nextLine().split("\\s+");
            String spell = command[0];
            int row = Integer.parseInt(command[1]);
            int col = Integer.parseInt(command[2]);

            hsPoints -= damage;
            if(activeCloud){
                playerPoints -= 3500;
                activeCloud = false;
                if (playerPoints < 0) {
                    break;
                }
            }

            if (hsPoints < 0) {
                break;
            }

            boolean[][] hsChamber = new boolean[15][15];
            for (int i = row - 1; i <= row + 1; i++) {
                if(i >= 0 && i < hsChamber.length){
                    for (int j = col - 1; j <= col + 1; j++) {
                        if(j >= 0 && j < hsChamber[row].length){
                            hsChamber[i][j] = true;
                        }
                    }
                }
            }

            if(hsChamber[playerRow][playerCol]){
                if(isRowInBounds(playerRow - 1, hsChamber) && !hsChamber[playerRow - 1][playerCol]){
                    playerRow--; // move up
                }else if(isColInBounds(playerCol + 1, hsChamber) && !hsChamber[playerRow][playerCol + 1]){
                    playerCol++; // move right
                }else if(isRowInBounds(playerRow + 1, hsChamber) && !hsChamber[playerRow + 1][playerCol]){
                    playerRow++; // move down
                }else if(isColInBounds(playerCol - 1, hsChamber) && !hsChamber[playerRow][playerCol - 1]){
                    playerCol--; // move left
                }
                if(hsChamber[playerRow][playerCol]){
                    switch (spell){
                        case "Cloud":
                            playerPoints -= 3500;
                            activeCloud = true;
                            lastSpell = "Plague Cloud";
                            break;
                        case "Eruption":
                            playerPoints -= 6000;
                            lastSpell = spell;
                            break;
                        default:
                            throw new IllegalArgumentException("Invalid spell: " + spell);
                    }
                }
            }
        }
        if(hsPoints > 0){
            System.out.printf("Heigan: %.2f%n", hsPoints);
        }else{
            System.out.println("Heigan: Defeated!");
        }
        if(playerPoints > 0){
            System.out.printf("Player: %d%n", playerPoints);
        }else{
            System.out.println("Player: Killed by " + lastSpell);
        }
        System.out.println("Final position: " + playerRow + ", " + playerCol);
    }


    private static boolean isRowInBounds(int row, boolean[][] matrix) {
        return row >= 0 && row < matrix[row].length;
    }

    private static boolean isColInBounds(int col, boolean[][] matrix) {
        return col >= 0 && col < matrix.length;
    }
}
