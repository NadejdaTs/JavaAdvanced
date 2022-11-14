package DefiningClassesEx4;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.ArrayList;
        import java.util.LinkedList;
        import java.util.List;
        import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        List<Car> cars = new LinkedList<>();

        while(n-- > 0){
            String[] input = bf.readLine().split("\\s+");
            String model = input[0];
            int engineSpeed = Integer.parseInt(input[1]);
            int enginePower = Integer.parseInt(input[2]);
            int cargoWeight = Integer.parseInt(input[3]);
            String cargoType = input[4];

            ArrayList<Tire> tires = new ArrayList<>();
            Tire tire = new Tire(Double.parseDouble(input[5]), Integer.parseInt(input[6]),
                    Double.parseDouble(input[7]), Integer.parseInt(input[8]),
                    Double.parseDouble(input[9]), Integer.parseInt(input[10]),
                    Double.parseDouble(input[11]), Integer.parseInt(input[12]));
            tires.add(tire);

            Car car = new Car(model, engineSpeed, enginePower, cargoWeight, cargoType, tires);
            cars.add(car);
        }

        String command = bf.readLine();
        if(command.equals("fragile")){
            //all cars with pressure < 1
            List<String> model = new ArrayList<>();
            for (int i = 0; i < cars.size(); i++) {
                if(cars.get(i).getTires().get(0).getPressure1() < 1 ||
                        cars.get(i).getTires().get(0).getPressure2() < 1 ||
                        cars.get(i).getTires().get(0).getPressure3() < 1 ||
                        cars.get(i).getTires().get(0).getPressure4() < 1){
                    model.add(cars.get(i).getModel());
                }
            }
            model.forEach(System.out::println);
        }else if(command.equals("flamable")){
            //all cars with engine power > 250
            cars.forEach(e -> {
                if(e.getCargoType().equals("flamable") && e.getEnginePower() >= 250){
                    System.out.println(String.format("%s", e.getModel()));
                }
            });
        }
    }
}
