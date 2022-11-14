package StacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        ArrayDeque<Character> stackOfBrackets = new ArrayDeque<>();
        boolean isBlanced = false;
        for (int i = 0; i < input.length(); i++) {
            char currentBracket = input.charAt(i);
            if (currentBracket == '{' || currentBracket == '(' || currentBracket == '[') {
                stackOfBrackets.push(currentBracket);
            } else if(currentBracket == '}' || currentBracket == ')' || currentBracket == ']'){
                if(stackOfBrackets.isEmpty()) {
                    isBlanced = false;
                    break;
                }
                char lastOpenBracket = stackOfBrackets.pop();
                if(lastOpenBracket == '(' && currentBracket == ')') {
                    isBlanced = true;
                }else if(lastOpenBracket == '{' && currentBracket == '}') {
                    isBlanced = true;
                }else if(lastOpenBracket == '[' && currentBracket == ']') {
                    isBlanced = true;
                }else {
                    isBlanced = false;
                    break;
                }
            }
        }

        if(isBlanced) {
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }
}
