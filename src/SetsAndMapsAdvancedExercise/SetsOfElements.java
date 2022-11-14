package SetsAndMapsAdvancedExercise;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new HashSet<>();
        getSetElements(firstSet, n, sc);
        getSetElements(secondSet, m, sc);

        firstSet.retainAll(secondSet);

        firstSet.forEach(e -> System.out.print(e + " "));
    }

    private static void getSetElements(Set<Integer> currentSet, int n, Scanner sc) {
        for (int i = 0; i < n; i++) {
            currentSet.add(Integer.parseInt(sc.nextLine()));
        }
    }
}
