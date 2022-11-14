package SetsAndMapsAdvancedLab;

import java.util.Scanner;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        TreeSet<String> vip = new TreeSet<>();
        TreeSet<String> regular = new TreeSet<>();

        while(!input.equals("PARTY")){
            String addPeople = "add";
            getPartyPeople(input, vip, regular, addPeople);
            input = sc.nextLine();
        }

        while(!input.equals("END")){
            String addPeople = "remove";
            getPartyPeople(input, vip, regular, addPeople);
            input = sc.nextLine();
        }

        System.out.println(vip.size() + regular.size());
        printMissingPartyPeople(vip);
        printMissingPartyPeople(regular);
    }

    private static void getPartyPeople(String input, TreeSet<String> vip, TreeSet<String> regular, String addOrRemove) {
        if(addOrRemove.equals("add")){
            if(Character.isDigit(input.charAt(0))){
                vip.add(input);
            }else{
                regular.add(input);
            }
        }else{
            if(Character.isDigit(input.charAt(0))){
                vip.remove(input);
            }else{
                regular.remove(input);
            }
        }
    }

    private static void printMissingPartyPeople(TreeSet<String> set) {
        if(!set.isEmpty()){
            System.out.println(String.join(System.lineSeparator(), set));
        }
    }
}
