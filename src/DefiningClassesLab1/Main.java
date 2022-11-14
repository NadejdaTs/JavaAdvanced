package DefiningClassesLab1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        List<Car> cars = new ArrayList<>();
        while(n-- > 0){
            String[] tokens = sc.nextLine().split("\\s+");
            Car car = new Car();

            car.setBrand(tokens[0]);
            car.setModel(tokens[1]);
            car.setHorsePower(Integer.parseInt(tokens[2]));

            cars.add(car);
        }

        cars.forEach(System.out::println);
    }
}
