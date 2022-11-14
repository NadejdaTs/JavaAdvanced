package SetsAndMapsAdvancedExercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        Map<String, Integer> countSymbols = new TreeMap<>();

        for (int i = 0; i < text.length(); i++) {
            String symbol = text.charAt(i) + "";

            if(!countSymbols.containsKey(symbol)){
                countSymbols.put(symbol, 1);
            }else{
                int currCount = countSymbols.get(symbol);
                countSymbols.put(symbol, currCount + 1);
            }
        }

        countSymbols.entrySet().stream()
                .forEach(entry -> System.out.printf("%s: %d time/s%n", entry.getKey(), entry.getValue()));
    }
}
