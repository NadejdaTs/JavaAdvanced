package FunctionalProgrammingExercise;

import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPrint {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split("\\s+");

        Consumer<String[]> printNames = names -> {
            for (int i = 0; i < names.length; i++) {
                System.out.println(names[i]);
            }
        };

        printNames.accept(input);
    }
}
