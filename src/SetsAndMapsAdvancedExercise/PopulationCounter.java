package SetsAndMapsAdvancedExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();

        Map<String, Long> totalOfPopulation = new LinkedHashMap<>();
        Map<String, LinkedHashMap<String, Long>> populationCounter = new LinkedHashMap<>();
        while(!command.equals("report")){
            String[] tokens = command.split("\\|");
            String city = tokens[0];
            String country = tokens[1];
            long population = Long.parseLong(tokens[2]);

            populationCounter.putIfAbsent(country, new LinkedHashMap<>());
            populationCounter.get(country).put(city, population);

            if(!totalOfPopulation.containsKey(country)){
                totalOfPopulation.put(country, population);
            }else{
                totalOfPopulation.put(country, totalOfPopulation.get(country) + population);
            }

            command = sc.nextLine();
        }


        totalOfPopulation.entrySet().stream()
                .sorted(Map.Entry.<String, Long> comparingByValue()
                        .reversed())
                .forEach(country -> {
                    System.out.printf("%s (total population: %d)%n", country.getKey(), country.getValue());
                    populationCounter.get(country.getKey()).entrySet().stream()
                            .sorted(Map.Entry.<String, Long> comparingByValue()
                                    .reversed())
                            .forEach(city -> System.out.printf("=>%s: %d%n", city.getKey(), city.getValue()));
                });
    }
}
