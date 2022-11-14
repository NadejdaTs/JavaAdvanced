package FunctionalProgrammingExercise;

import java.util.Scanner;
import java.util.function.Consumer;

public class KnightsOfHonor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] names = sc.nextLine().split("\\s+");

        Consumer<String> print = System.out::println;

        for (String name : names) {
            print.accept("Sir " + name);
        }
    }
}
