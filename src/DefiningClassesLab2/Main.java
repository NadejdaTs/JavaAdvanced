package DefiningClassesLab2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        List<CarConstructors> cars = new ArrayList<>();
        while(n-- > 0){
            String[] tokens = sc.nextLine().split("\\s+");
            CarConstructors car;

            if(tokens.length == 1){
                car = new CarConstructors(tokens[0]);
            }else{
                car = new CarConstructors(tokens[0], tokens[1], Integer.parseInt(tokens[2]));
            }
            cars.add(car);
        }

        cars.forEach(System.out::println);
    }
}
