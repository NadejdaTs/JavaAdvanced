package StacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicStackOperations {
    //for 04. BasicQueueOperations too
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int s = sc.nextInt();
        int x = sc.nextInt();

        ArrayDeque<Integer> stackOfNumbers = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            stackOfNumbers.push(sc.nextInt());
        }

        for (int i = 0; i < s; i++) {
            stackOfNumbers.pop();
        }

        boolean sFlag = false;
        int smallest = Integer.MAX_VALUE;
        for (Integer number : stackOfNumbers) {
            if(x == number){
                System.out.println("true");
                sFlag = true;
                break;
            }else if(smallest > number){
                smallest = number;
            }
        }

        if(!sFlag){
            if(stackOfNumbers.isEmpty()){
                System.out.println(0);
            }else{
                System.out.println(smallest);
            }
        }
    }
}
