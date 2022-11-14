package SetsAndMapsAdvancedExercise;

import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        Map<String, LinkedHashSet<String>> handsOfCards = new LinkedHashMap<>();
        while(!input.equals("JOKER")){
            String[] command = input.split(":\\s+");
            String name = command[0];
            String[] items = command[1].split(",\\s+");

            LinkedHashSet<String> newCads = new LinkedHashSet<>();
            for (String item : items) {
                newCads.add(item);
            }

            if(!handsOfCards.containsKey(name)){
                handsOfCards.put(name, new LinkedHashSet<>());
                handsOfCards.put(name, newCads);
            }else{
                LinkedHashSet<String> current = handsOfCards.get(name);
                newCads.addAll(current);
                handsOfCards.put(name, newCads);
            }
            input = sc.nextLine();
        }

        for (var entry : handsOfCards.entrySet()) {
            int sum = 0;
            for (var item : entry.getValue()) {
                String stringPower  = item.substring(0, item.length() - 1);
                String stringType  = item.substring(item.length() - 1);
                int power = getPower(stringPower);
                int type = getType(stringType);

                sum += power * type;
            }
            System.out.printf("%s: %d%n", entry.getKey(), sum);
        }

    }

    private static int getType(String stringType) {
        int type = 0;
        switch(stringType){
            case "S":
                type = 4;
                break;
            case "H":
                type = 3;
                break;
            case "D":
                type = 2;
                break;
            case "C":
                type = 1;
                break;
        }

        return type;
    }

    private static int getPower(String stringPower) {
        int power = 0;
        if(Character.isDigit(stringPower.charAt(0))){
            power = Integer.parseInt(stringPower);
        }else{
            switch(stringPower){
                case "J":
                    power = 11;
                    break;
                case "Q":
                    power = 12;
                    break;
                case "K":
                    power = 13;
                    break;
                case "A":
                    power = 14;
                    break;
            }
        }

        return power;
    }
}
