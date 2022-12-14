package SetsAndMapsAdvancedLab;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        LinkedHashSet<String> parkingLot = new LinkedHashSet<>();
        while(!input.equals("END")){
            String car = input.split("\\s+")[1];

            if(input.contains("IN")){
                parkingLot.add(car);
            }else{
                parkingLot.remove(car);
            }

            input = sc.nextLine();
        }
        if(parkingLot.isEmpty()){
            System.out.println("Parking Lot is Empty");
        }else{
            System.out.println(String.join(System.lineSeparator(), parkingLot));
        }
    }
}
