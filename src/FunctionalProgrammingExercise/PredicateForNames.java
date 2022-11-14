package FunctionalProgrammingExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        String[] names = sc.nextLine().split("\\s+");

        Predicate<String> checkNameLength = name -> name.length() <= n;

        for (String name : names) {
            if(checkNameLength.test(name)){
                System.out.println(name);
            }
        }
    }
}
