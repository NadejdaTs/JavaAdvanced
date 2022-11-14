package DefiningClassesEx4;

import java.util.ArrayList;

public class Car {
    private String model;
    private int engineSpeed;
    private int enginePower;
    private int cargoWeight;
    private String cargoType;
    private ArrayList<Tire> tires;

    public Car(String model, int engineSpeed, int enginePower, int cargoWeight, String cargoType, ArrayList<Tire> tires){
        this.model = model;
        this.engineSpeed = engineSpeed;
        this.enginePower = enginePower;
        this.cargoWeight = cargoWeight;
        this.cargoType = cargoType;
        this.tires = tires;
    }

    public ArrayList<Tire> getTires(){
        return tires;
    }

    public void setTires(ArrayList<Tire> tires){
        this.tires = tires;
    }

    public String getModel(){
        return model;
    }

    public void setModel(String model){
        this.model = model;
    }

    public String getCargoType(){
        return cargoType;
    }

    public void setCargoType(String cargoType){
        this.cargoType = cargoType;
    }

    public int getEngineSpeed() {
        return engineSpeed;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public int getCargoWeight() {
        return cargoWeight;
    }

    public void setEngineSpeed(int engineSpeed) {
        this.engineSpeed = engineSpeed;
    }

    public void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }

    public void setCargoWeight(int cargoWeight) {
        this.cargoWeight = cargoWeight;
    }
}

