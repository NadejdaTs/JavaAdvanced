package StacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        ArrayDeque<String> stack = new ArrayDeque<>();
        String text = "";

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split("\\s+");
            int command = Integer.parseInt(input[0]);

            switch (command){
                case 1:
                    stack.push(text);
                    text += input[1];
                    break;
                case 2:
                    stack.push(text);
                    int count = Integer.parseInt(input[1]);
                    text = text.substring(0, text.length() - count);
                    break;
                case 3:
                    int index = Integer.parseInt(input[1]);;
                    System.out.println(text.charAt(index - 1));
                    break;
                case 4:
                    text = stack.pop();
                    break;
            }
        }
    }
}
