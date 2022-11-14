package StacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        ArrayDeque<Integer> stackOfNumbers = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split(" ");
            int command = Integer.parseInt(input[0]);

            switch (command){
                case 1:
                    int elementsToPush = Integer.parseInt(input[1]);
                    stackOfNumbers.push(elementsToPush);
                    break;
                case 2:
                    stackOfNumbers.pop();
                    break;
                case 3:
                    int maxElement = 0;
                    for (Integer number : stackOfNumbers) {
                        if(maxElement < number){
                            maxElement = number;
                        }
                    }

                    System.out.println(maxElement);
                    break;
            }
        }
    }
}
