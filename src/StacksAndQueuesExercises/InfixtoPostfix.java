package SetsAndMapsAdvancedExercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class InfixtoPostfix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] inputExpression = sc.nextLine().split(" ");

        ArrayDeque<String> queueOutput = new ArrayDeque<>();
        ArrayDeque<String> stackOperators = new ArrayDeque<>();
        for (int i = 0; i < inputExpression.length; i++) {
            String currentElement = inputExpression[i];
            switch(currentElement){
                case "+":
                case "-":
                    while(!stackOperators.isEmpty() && !stackOperators.peek().equals("(")){
                        queueOutput.offer(stackOperators.pop());
                    }
                    stackOperators.push(currentElement);
                    break;
                case "*":
                case "/":
                    while(!stackOperators.isEmpty() && !"+-(".contains(stackOperators.peek())){
                        queueOutput.offer(stackOperators.pop());
                    }
                    stackOperators.push(currentElement);
                    break;
                case "(":
                    stackOperators.push(currentElement);
                    break;
                case ")":
                    while(!stackOperators.peek().equals("(")){
                        queueOutput.offer(stackOperators.pop());
                    }
                    stackOperators.pop();
                    break;
                default:
                    queueOutput.offer(currentElement);
                    break;
            }
        }
        while(!stackOperators.isEmpty()){
            queueOutput.offer(stackOperators.pop());
        }
        System.out.println(String.join(" ", queueOutput));
    }
}
