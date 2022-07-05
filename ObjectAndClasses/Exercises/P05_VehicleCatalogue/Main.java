package ProgrammingFundamentals.ObjectAndClasses.Exercises.P05_VehicleCatalogue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputLine = scanner.nextLine();
        List<Vehicle> listTrucks = new ArrayList<>();
        List<Vehicle> listCars = new ArrayList<>();

        String type = "";
        String model = "";
        String color = "";
        double horsePower = 0;
        Vehicle vehicleObj = new Vehicle(type, model, color, horsePower);

        int counterCars = 0;
        int counterTrucks = 0;
        double totalTruckHP = 0;
        double totalCarsHP = 0;
        while (!inputLine.equals("End")) {
            type = inputLine.split(" ")[0];
            model = inputLine.split(" ")[1];
            color = inputLine.split(" ")[2];
            horsePower = Integer.parseInt(inputLine.split(" ")[3]);
            vehicleObj = new Vehicle(type, model, color, horsePower);
            switch (type) {

                case "truck":
                    listTrucks.add(vehicleObj);
                    totalTruckHP += horsePower;
                    counterTrucks++;
                    break;
                case "car":
                    listCars.add(vehicleObj);
                    counterCars++;
                    totalCarsHP += horsePower;
                    break;
            }

            inputLine = scanner.nextLine();
        }
        String inputs = scanner.nextLine();
        while (!inputs.equals("Close the Catalogue")) {
            for (Vehicle car : listCars) {
                if (inputs.equals(car.getModel())) {
                    System.out.print(car.toString());
                }
            }
            for (Vehicle truck : listTrucks) {
                if (inputs.equals(truck.getModel())) {
                    System.out.print(truck.toString());
                }
            }

            inputs = scanner.nextLine();
        }
        if (totalCarsHP > 0) {
            System.out.printf("Cars have average horsepower of: %.2f.%n",totalCarsHP/counterCars);
        } else {
            System.out.println("Cars have average horsepower of: 0.00.");
        }
        if (totalTruckHP > 0) {
            System.out.printf("Trucks have average horsepower of: %.2f.%n",totalTruckHP/counterTrucks);
        }else {
            System.out.println("Trucks have average horsepower of: 0.00.");
        }

    }
}
