package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split("\\s+");
        int hotPotato = Integer.parseInt(sc.nextLine());

        ArrayDeque<String> nameOfKids = new ArrayDeque<>();

        for (String element : input) {
            nameOfKids.offer(element);
        }

        int countPotato = 1;
        while(nameOfKids.size() > 1){
            String currentKid = nameOfKids.poll();
            if(countPotato == hotPotato){
                System.out.println("Removed " + currentKid);
                countPotato = 1;
            }else{
                nameOfKids.offer(currentKid);
                countPotato++;
            }
        }
        System.out.println("Last is " + nameOfKids.poll());
    }
}
