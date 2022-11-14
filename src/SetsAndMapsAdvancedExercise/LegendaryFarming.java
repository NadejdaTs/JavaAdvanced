package AssociativeArraysExercise;

import java.util.Scanner;
import java.util.TreeMap;

public class LegendaryFarming {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();

        TreeMap<String, Integer> legendaryFarming = new TreeMap<>() {{
            put("fragments", 0);
            put("shards", 0);
            put("motes", 0);
        }};

        TreeMap<String, Integer> junk = new TreeMap<>();
        String winner = "";
        while (winner == "") {
            String[] words = command.split("\\s+");
            for (int i = 0; i < words.length; i += 2) {
                String item = words[i + 1].toLowerCase();
                int quantity = Integer.parseInt(words[i]);

                if (item.equals("fragments") || item.equals("shards") || item.equals("motes")) {
                    legendaryFarming.put(item, legendaryFarming.get(item) + quantity);
                    if (legendaryFarming.get(item) >= 250) {
                        winner = item;
                        legendaryFarming.put(item, legendaryFarming.get(item) - 250);
                        break;
                    }
                } else {
                    if(!junk.containsKey(item)) {
                        junk.put(item, 0);
                    }
                    junk.put(item, junk.get(item) + quantity);
                }
            }
            if (winner == "") {
                command = sc.nextLine();
            }
        }
        if (winner.equals("fragments")) {
            System.out.println("Valanyr obtained!");
        } else if (winner.equals("shards")) {
            System.out.println("Shadowmourne obtained!");
        } else if (winner.equals("motes")) {
            System.out.println("Dragonwrath obtained!");
        }

        legendaryFarming.entrySet().stream().sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .forEach(e -> System.out.printf("%s: %d%n", e.getKey(), e.getValue()));

        junk.forEach((k, v) -> System.out.println(k + ": " + v));
    }
}
