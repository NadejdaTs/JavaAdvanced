package DefiningClassesEx4;

public class Cargo {
    private int cargoWight;
    private String cargoType;

    public Cargo(int cargoWight, String cargoType){
        this.cargoWight = cargoWight;
        this.cargoType = cargoType;
    }

    public String getCargoType(){
        return cargoType;
    }
}