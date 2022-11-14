package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int decimalNumber = Integer.valueOf(sc.nextLine());

        if(decimalNumber == 0){
            System.out.print(0);
            return;
        }

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        while(decimalNumber != 0){
            stack.push(decimalNumber % 2);
            decimalNumber /= 2;
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}
