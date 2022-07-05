package ProgrammingFundamentals.ObjectAndClasses.Exercises.P05_VehicleCatalogue;

import java.util.Locale;

public class Vehicle {
    String type;
    String model;
    String color;
   double horsePower;

   public Vehicle(String type, String model, String color, double horsePower){
        this.type = type;
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
    }

    public String getType() {
        return type;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }



    public double getHorsePower() {
        return horsePower;
    }

    @Override
    public String toString() {
        return String.format("Type: %s%nModel: %s%nColor: %s%nHorsepower: %.0f%n",(this.type.substring(0,1).toUpperCase()+this.type.substring(1)),
                this.model,this.color,this.horsePower);    }
}
