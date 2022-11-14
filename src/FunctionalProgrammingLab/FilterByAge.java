package FunctionalProgrammingLab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;

public class FilterByAge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        LinkedHashMap<String, Integer> people = new LinkedHashMap<>();
        while(n-- > 0){
            String[] tokens = sc.nextLine().split(", ");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            people.put(name, age);
        }

        String ageCondition = sc.nextLine();
        int age = Integer.parseInt(sc.nextLine());
        String format = sc.nextLine();

        Predicate<Map.Entry<String, Integer>> ageFilter =
                getAgeFilter(age, ageCondition);

        people.entrySet().stream()
                .filter(ageFilter)
                .forEach(entry -> {
                    if(format.equals("name")){
                        System.out.println(entry.getKey());
                    }else if(format.equals("age")){
                        System.out.println(entry.getValue());
                    }else{
                        System.out.println(entry.getKey() + " - " + entry.getValue());
                    }
                });
    }

    private static Predicate<Map.Entry<String, Integer>> getAgeFilter(int age, String ageCondition){
        if(ageCondition.equals("older")){
            return e -> e.getValue() >= age;
        }
        return e -> e.getValue() <= age;
    }
}
