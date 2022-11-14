package DefiningClassesEx3;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCost;
    private double distance;

    public Car(String model, double fuelAmount, double fuelCost){
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCost = fuelCost;
        this.distance = 0;
    }

    public void moveCar(double distance){
        double fuelNeeded = distance * this.fuelCost;
        if(fuelNeeded <= this.fuelAmount){
            this.fuelAmount -= fuelNeeded;
            this.distance += distance;
        }else{
            System.out.printf("Insufficient fuel for the drive%n");
        }
    }

    @Override
    public String toString(){
        return String.format("%s %.2f %.0f", this.model, this.fuelAmount, this.distance);
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public void setFuelCost(double fuelCost) {
        this.fuelCost = fuelCost;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getDistance(){
        return this.distance;
    }

    public String getModel(){
        return this.model;
    }

    public double getFuelAmount(){
        return this.fuelAmount;
    }

    public double getFuelCost(){
        return this.fuelCost;
    }
}
