package StacksAndQueuesExercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String command = sc.nextLine();
        Map<String, String> emails = new LinkedHashMap<>();
        int count = 0;
        String name = "";
        while(!command.equals("stop")){
            if(count % 2 == 0){
                name = command;
            }else{
                String[] emailPart = command.split("\\.");
                String lastPart = emailPart[emailPart.length - 1];
                if(!lastPart.equals("us") && !lastPart.equals("uk") && !lastPart.equals("com")){
                    emails.put(name, command);
                }
            }

            count++;
            command = sc.nextLine();
        }

        emails.entrySet().stream()
                .forEach((pair) -> {
                    System.out.printf("%s -> %s%n", pair.getKey(), pair.getValue());
                });
    }
}
