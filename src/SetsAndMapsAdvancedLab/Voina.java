package SetsAndMapsAdvancedLab;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Voina {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedHashSet<Integer> firstDeck = readDeck(sc.nextLine());
        LinkedHashSet<Integer> secondDeck = readDeck(sc.nextLine());
        int round = 50;

        while(round-- > 0){
            int firstCard = getFirst(firstDeck);
            int secondCard = getFirst(secondDeck);

            firstDeck.remove(firstCard);
            secondDeck.remove(secondCard);

            if(firstCard > secondCard){
                firstDeck.add(firstCard);
                firstDeck.add(secondCard);
            }else if(secondCard > firstCard){
                secondDeck.add(firstCard);
                secondDeck.add(secondCard);
            }

            if(firstDeck.isEmpty() || secondDeck.isEmpty()) {
                break;
            }
        }
        if(firstDeck.size() > secondDeck.size()){
            System.out.println("First player win!");
        }else if(secondDeck.size() > firstDeck.size()){
            System.out.println("Second player win!");
        }else{
            System.out.println("Draw!");
        }
    }

    private static int getFirst(LinkedHashSet<Integer> set){
        for (Integer card : set) {
            return card;
        }
        return 0;
    }

    private static LinkedHashSet<Integer> readDeck(String nextLine) {
        return Arrays.stream(nextLine.split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
}
