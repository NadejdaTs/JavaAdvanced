package SetsAndMapsAdvancedExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();

        Map<String,String> phoneBook = new LinkedHashMap<>();
        while(!command.equals("search")){
            String name = command.split("-")[0];
            String phone = command.split("-")[1];
            phoneBook.put(name, phone);

            command = sc.nextLine();
        }
        while(!command.equals("stop")){
            if(!command.equals("search")){
                if(!phoneBook.containsKey(command)){
                    System.out.printf("Contact %s does not exist.%n", command);
                }else{
                    System.out.printf("%s -> %s%n", command, phoneBook.get(command));
                }
            }

            command = sc.nextLine();
        }
    }
}
