package ProgrammingFundamentals.ObjectAndClasses.MoreExercises.P02_RawData;

import java.util.List;

public class Car {
   private String model;
   private int speed;
    private  int power;
    private List<Tiers> tiersList;
    private String cargoType;


    public Car(String model, int speed, int power, List<Tiers> tiersList, String cargoType) {
        this.model = model;
        this.speed = speed;
        this.power = power;
        this.tiersList = tiersList;
        this.cargoType = cargoType;

    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }


    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public List<Tiers> getTiersList() {
        return tiersList;
    }

    public void setTiersList(List<Tiers> tiersList) {
        this.tiersList = tiersList;
    }


    public String getCargoType() {
        return cargoType;
    }

    public void setCargoType(String cargoType) {
        this.cargoType = cargoType;
    }
}
