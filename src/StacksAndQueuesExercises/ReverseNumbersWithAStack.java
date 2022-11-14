package StacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt)
                .collect(Collectors.toList());

        ArrayDeque<Integer> stackOfNumbers = new ArrayDeque<>();

        for (Integer number : numbers) {
            stackOfNumbers.push(number);
        }

        for (Integer stackOfNumber : stackOfNumbers) {
            System.out.print(stackOfNumbers.pop() + " ");
        }
    }
}
