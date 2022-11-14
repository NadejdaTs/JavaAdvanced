package StacksAndQueuesExercises;

import java.util.*;
import java.util.stream.Collectors;

public class PoisonousPlants {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<Long> arrayOfNumbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Long::parseLong)
                .collect(Collectors.toList());

        ArrayDeque<Long> queue = new ArrayDeque<>();
        int countDead = 0;
        boolean isDead = true;
        while(isDead){
            isDead = false;
            long prevDifference = 0;
            for (int i = 0; i < arrayOfNumbers.size(); i++) {
                long currPlant = arrayOfNumbers.get(i);
                long currDifference = currPlant - (i + 1);
                if(i > 1){
                    if(currDifference > prevDifference){
                        queue.offer(currPlant);
                        isDead = true;
                    }
                }
                prevDifference = currPlant - i;
            }
            while (!queue.isEmpty()) {
                arrayOfNumbers.remove(queue.poll());
            }
            if(isDead){
                countDead++;
            }
        }
        System.out.println(countDead);
    }
}
