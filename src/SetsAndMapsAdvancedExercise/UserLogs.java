package SetsAndMapsAdvancedExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UserLogs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Map<String, Integer>> userLog = new TreeMap<>();
        String input = "";
        while (!(input = sc.nextLine()).equals("end")){
            String[] command = input.split("\\s+");
            String ip = command[0].substring(3);
            String user = command[2].substring(5);

            userLog.putIfAbsent(user, new LinkedHashMap<>());
            Map<String, Integer> innerMap = userLog.get(user);
            innerMap.putIfAbsent(ip, 0);
            innerMap.put(ip, innerMap.get(ip) + 1);
        }

        userLog.entrySet().stream()
                .forEach((pair) -> {
                    System.out.printf("%s:%n", pair.getKey());
                    int count = 0;
                    Map<String, Integer> map = pair.getValue();
                    for (var item : map.entrySet()) {
                        String format = (count++ == map.size() - 1)
                                ? "%s => %d.%n"
                                : "%s => %d, ";
                        System.out.printf(format, item.getKey(), item.getValue());
                    }
                });
    }
}
