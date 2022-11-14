package SetsAndMapsAdvancedExercise;

import java.util.*;

public class DragonArmy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Map<String, List<String>> typeAndName = new LinkedHashMap<>();
        Map<String, String[]> dragons = new TreeMap<>();
        while(n-- > 0){
            String[] input = sc.nextLine().split(" ");

            String type = input[0];
            String name = input[1];
            String damage = input[2];
            String health = input[3];
            String armor = input[4];
            if(damage.equals("null")){
                damage = "45";
            }
            if(health.equals("null")){
                health = "250";
            }
            if(armor.equals("null")){
                armor = "10";
            }

            typeAndName.putIfAbsent(type, new ArrayList<>());
            typeAndName.get(type).add(name);

            String currentName = name + "-" + type;
            if(!dragons.containsKey(currentName)){
                dragons.put(currentName, new String[3]);
            }
            String[] currentStat = new String[3];
            currentStat[0] = damage;
            currentStat[1] = health;
            currentStat[2] = armor;
            dragons.put(currentName, currentStat);
        }

        Set<String> currentTypeList = new LinkedHashSet<>();
        for (var type : typeAndName.entrySet()) {
            String currentType = type.getKey();
            if(!currentTypeList.contains(currentType)){
                currentTypeList.add(currentType);
                double damage = 0.0;
                double health = 0.0;
                double armor = 0.0;
                int count = 0;
                StringBuilder sb = new StringBuilder();
                for (var dragon : dragons.entrySet()) {
                    String[] name = dragon.getKey().split("-");
                    if(name[1].equals(currentType)){
                        String[] current = dragon.getValue();
                        damage += Double.parseDouble(current[0]);
                        health += Double.parseDouble(current[1]);
                        armor += Double.parseDouble(current[2]);
                        count++;
                        String dragonInfo = String.format("-%s -> damage: %s, health: %s, armor: %s%n", name[0], current[0], current[1], current[2]);
                        sb.append(dragonInfo);
                    }
                }
                damage /= count;
                health /= count;
                armor /= count;
                System.out.printf("%s::(%.2f/%.2f/%.2f)%n", currentType, damage, health, armor);
                System.out.print(sb.toString());
            }
        }
    }
}
