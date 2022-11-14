package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MathPatato {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split("\\s+");
        int hotPotato = Integer.parseInt(sc.nextLine());

        ArrayDeque<String> nameOfKids = new ArrayDeque<>();

        for (String element : input) {
            nameOfKids.offer(element);
        }

        int countPotato = 1;
        int primeOrNot = 1;
        while(nameOfKids.size() > 1){
            if(countPotato == hotPotato){
                if(isPrime(primeOrNot)){
                    System.out.println("Prime " + nameOfKids.peek());
                }else{
                    System.out.println("Removed " + nameOfKids.poll());
                }
                countPotato = 1;
                primeOrNot++;
            }else{
                nameOfKids.offer(nameOfKids.poll());
                countPotato++;
            }
        }
        System.out.println("Last is " + nameOfKids.poll());
    }
    static boolean isPrime(int n)
    {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i < n; i++){
            if (n % i == 0){
                return false;
            }
        }

        return true;
    }
}
