package DefiningClassesEx3;

        import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        Car car;
        List<Car> cars = new ArrayList<>();
        while(n-- > 0){
            String[] tokens = sc.nextLine().split(" ");
            String model = tokens[0];
            double fuelAmt = Double.parseDouble(tokens[1]);
            double fuelCostPerKm = Double.parseDouble(tokens[2]);

            if(cars.isEmpty()){
                car = new Car(model, fuelAmt, fuelCostPerKm);
                cars.add(car);
            }else{
                boolean flag = false;
                for (Car c : cars) {
                    if(c.getModel().equals(model)){
                        flag = true;
                    }
                }
                if(!flag){
                    car = new Car(model, fuelAmt, fuelCostPerKm);
                    cars.add(car);
                }
            }
        }

        String command = sc.nextLine();
        while(!command.equals("End")){
            String model = command.split(" ")[1];
            double distance = Double.parseDouble(command.split(" ")[2]);

            for (Car c : cars) {
                if(c.getModel().equals(model)){
                    c.moveCar(distance);
                }
            }
            command = sc.nextLine();
        }

        cars.stream().forEach(System.out::println);
    }
}

