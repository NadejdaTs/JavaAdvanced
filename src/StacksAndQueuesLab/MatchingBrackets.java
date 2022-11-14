package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String expression = sc.nextLine();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < expression.length(); i++) {
            char currentElement = expression.charAt(i);

            if(currentElement == '('){
                stack.push(i);
            }else if(currentElement == ')'){
                int startIndex = stack.pop();
                String contents = expression.substring(startIndex, i+1);
                System.out.println(contents);
            }
        }
    }
}
