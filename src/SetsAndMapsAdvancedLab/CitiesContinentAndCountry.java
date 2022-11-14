package SetsAndMapsAdvancedLab;

import java.util.*;

public class CitiesContinentAndCountry {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        LinkedHashMap<String, LinkedHashMap<String, List<String>>>
                infoTable = new LinkedHashMap<>();

        while(n-- > 0){
            String[] input = sc.nextLine().split("\\s+");
            String continent = input[0];
            String country = input[1];
            String city = input[2];

            infoTable.putIfAbsent(continent, new LinkedHashMap<>());
            LinkedHashMap<String, List<String>> innerMap = infoTable.get(continent);
            innerMap.putIfAbsent(country, new ArrayList<>());
            innerMap.get(country).add(city);
        }

        for (var entry : infoTable.entrySet()) {
            String continent = entry.getKey();
            LinkedHashMap<String, List<String>> innerMap = entry.getValue();

            System.out.println(continent + ":");

            for (var innerEntry : innerMap.entrySet()) {
                System.out.println("  " + innerEntry.getKey() + " -> "
                        + String.join(", ", innerEntry.getValue()));
            }
        }
    }
}
