package SetsAndMapsAdvancedExercise;

import java.util.*;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        TreeMap<String, TreeMap<String, Integer>> logs = new TreeMap<>();
        while(n-- > 0){
            String[] tokens = sc.nextLine().split("\\s+");
            String ip = tokens[0];
            String name = tokens[1];
            int duration = Integer.parseInt(tokens[2]);

            if(!logs.containsKey(name)){
                logs.put(name, new TreeMap<>());
                logs.get(name).put(ip, duration);
            }else{
                if(!logs.get(name).containsKey(ip)){
                    logs.get(name).put(ip, duration);
                }else{
                    duration += logs.get(name).get(ip);
                    logs.get(name).put(ip, duration);
                }
            }
        }

        for (var name : logs.keySet()) {
            int sum = 0;
            System.out.print(name + ": ");
            for (Integer value : logs.get(name).values()) {
                sum += value;
            }
            System.out.print(sum + " ");
            System.out.println(logs.get(name).keySet());
        }
    }
}
