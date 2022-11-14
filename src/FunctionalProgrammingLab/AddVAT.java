package FunctionalProgrammingLab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class AddVAT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Function<String, Double> mapToVat = str ->
                Double.parseDouble(str) *1.2;

        System.out.println("Prices with VAT:");

        Arrays.stream(sc.nextLine().split(", "))
                .map(mapToVat)
                .forEach(e -> System.out.printf("%.2f%n", e));
    }
}
