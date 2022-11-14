package SetsAndMapsAdvancedLab;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        TreeMap<String, double[]> studentGrades = new TreeMap<>();

        while(n-- > 0){
            String name = sc.nextLine();
            double[] grades = Arrays.stream(sc.nextLine().split("\\s+"))
                    .mapToDouble(Double::parseDouble)
                    .toArray();
            studentGrades.put(name, grades);
        }

        for (var entry : studentGrades.entrySet()) {
            double avg = Arrays.stream(entry.getValue()).average().orElse(0);
            DecimalFormat df = new DecimalFormat("#.#####################");
            System.out.printf("%s is graduated with %s%n", entry.getKey(), df.format(avg));
        }
    }
}
