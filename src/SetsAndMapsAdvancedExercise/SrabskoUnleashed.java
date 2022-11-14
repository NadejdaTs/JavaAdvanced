package SetsAndMapsAdvancedExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SrabskoUnleashed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();

        Map<String, LinkedHashMap<String, Integer>> singersAndPrices = new LinkedHashMap<>();
        while(!command.equals("End")){
            if(isValidCommand(command)){
                String[] tokens = command.split("@");
                String singer = tokens[0].trim();

                int index = 0;
                for (int i = 0; i < tokens[1].length(); i++) {
                    if(Character.isDigit(tokens[1].charAt(i))){
                        index = i;
                        break;
                    }
                }

                String venue = tokens[1].substring(0, index - 1);
                String[] priceAndCount = tokens[1].substring(index).split(" ");
                int ticketPrice = Integer.parseInt(priceAndCount[0]);
                int ticketCount = Integer.parseInt(priceAndCount[1]);

                singersAndPrices.putIfAbsent(venue, new LinkedHashMap<>());
                int currentPrice = ticketPrice * ticketCount;
                if(!singersAndPrices.get(venue).containsKey(singer)){
                    singersAndPrices.get(venue).put(singer, currentPrice);
                }else{
                    int current = singersAndPrices.get(venue).get(singer);
                    singersAndPrices.get(venue).put(singer, current + currentPrice);
                }
                command = sc.nextLine();
            }else{
                command = sc.nextLine();
            }
        }
        singersAndPrices.entrySet().stream()
                .forEach(pair -> {
                    System.out.println(pair.getKey());
                    pair.getValue().entrySet().stream()
                            .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                            .forEach(singer -> {
                                System.out.printf("#  %s -> %d%n", singer.getKey(), singer.getValue());
                            });
                });
    }

    private static boolean isValidCommand(String command) {
        String[] tokens = command.split("@");

        String test = tokens[0].substring(tokens[0].length() - 1);
        if(!tokens[0].substring(tokens[0].length() - 1).equals(" ")){
            return false;
        }
        int index = 0;
        for (int i = 0; i < tokens[1].length(); i++) {
            if(Character.isDigit(tokens[1].charAt(i))){
                index = i;
                break;
            }
        }
        if(index == 0 || !tokens[1].substring(index - 1, index).equals(" ")){
            return false;
        }

        return true;
    }
}
