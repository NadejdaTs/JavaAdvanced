package FunctionalProgrammingLab;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] words = sc.nextLine().split(" ");

        Predicate<String> uppercase = e -> Character.isUpperCase(e.charAt(0));

        ArrayList<String> uppercaseList = new ArrayList<>();
        int count = 0;
        for (String word : words) {
            if(uppercase.test(word)){
                uppercaseList.add(word);
                count++;
            }
        }

        System.out.println(count);
        uppercaseList.stream()
                .forEach(e -> System.out.println(e));
    }
}
