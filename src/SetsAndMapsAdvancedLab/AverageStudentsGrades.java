package SetsAndMapsAdvancedLab;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Map<String, ArrayList<Double>> students = new TreeMap<>();
        while(n-- > 0){
            String[] input = sc.nextLine().split("\\s+");
            String name = input[0];
            double grade = Double.parseDouble(input[1]);

            if(!students.containsKey(name)){
                students.putIfAbsent(name, new ArrayList<Double>());
                students.get(name).add(grade);
            }else{
                students.get(name).add(grade);
            }
        }

        students.entrySet().stream()
                .forEach((k) -> {
                    System.out.printf("%s -> ", k.getKey());
                    double sum = 0.0;
                    for (var entry : k.getValue()) {
                        sum += entry;
                        System.out.printf("%.2f ", entry);
                    }
                    System.out.printf("(avg: %.2f)%n", sum / k.getValue().size());
                });

        /*for (var entry : students.entrySet()) {
            double sum = 0.0;
            for (var innerEntry : entry.getValue()) {
                sum += innerEntry;
            }
            String grades = String.join(" ", entry.getValue().toString().replaceAll("[\\]\\[]", ""));
            System.out.printf("%s -> %s (avg: %.2f)%n", entry.getKey(), grades, sum/entry.getValue().size());
        }*/
    }
}
