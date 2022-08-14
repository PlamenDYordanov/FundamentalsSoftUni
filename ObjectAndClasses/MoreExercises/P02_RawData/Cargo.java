package ProgrammingFundamentals.ObjectAndClasses.MoreExercises.P02_RawData;

public class Cargo {
    private int cargoWeight;
    private String type;

    public Cargo(int cargoWeight, String type) {
        this.cargoWeight = cargoWeight;
        this.type = type;
    }


    public int getCargoWeight() {
        return cargoWeight;
    }

    public void setCargoWeight(int cargoWeight) {
        this.cargoWeight = cargoWeight;
    }

    public String getCargoType() {
        return type;
    }

    public void setCargoType(String cargoType) {
        this.type = cargoType;
    }
}
