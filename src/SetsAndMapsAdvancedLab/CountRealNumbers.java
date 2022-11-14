package SetsAndMapsAdvancedLab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] realNumbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();

        Map<Double, Integer> mapOfRealNumbers = new LinkedHashMap<>();
        for (int i = 0; i < realNumbers.length; i++) {
            double current = realNumbers[i];
            if(!mapOfRealNumbers.containsKey(current)){
                mapOfRealNumbers.put(current, 1);
            }else{
                mapOfRealNumbers.put(realNumbers[i], mapOfRealNumbers.get(current) + 1);
            }
        }

        for (var entry : mapOfRealNumbers.entrySet()) {
            System.out.printf("%.1f -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
