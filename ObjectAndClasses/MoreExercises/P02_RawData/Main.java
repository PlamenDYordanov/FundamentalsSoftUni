package ProgrammingFundamentals.ObjectAndClasses.MoreExercises.P02_RawData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Car> carList = new ArrayList<>();
        List<Cargo> cargoList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Tiers> tiersList = new ArrayList<>();
            String[] inputLine = scanner.nextLine().split("\\s+");


            String model = (inputLine[0]);
            int speed = (Integer.parseInt(inputLine[1]));
            int power = (Integer.parseInt(inputLine[2]));


            int cargoWeight = (Integer.parseInt(inputLine[3]));
            String typeCargo = inputLine[4];
            Cargo cargo = new Cargo(cargoWeight, typeCargo);
            cargoList.add(cargo);

            for (int j = 5; j < inputLine.length - 1; j += 2) {
                int age = Integer.parseInt(inputLine[j + 1]);
                double pressure = Double.parseDouble(inputLine[j]);
                Tiers tiers = new Tiers(pressure, age);
                tiersList.add(tiers);

            }
            Car car = new Car(model, speed, power, tiersList, typeCargo);
            carList.add(car);

        }
        String command = scanner.nextLine();
        if (command.equals("fragile")) {
            for (Car car : carList) {
                if (car.getCargoType().equals("fragile")) {
                    car.getTiersList().stream().limit(1).forEach(e -> {
                        if (e.getPressure() < 1) {
                            System.out.println(car.getModel());

                        }
                    });
                }
            }


        } else if (command.equals("flamable")) {
            carList.forEach(e -> {
                if (e.getCargoType().equals("flamable")) {

                    if (e.getPower() > 250) {
                        System.out.println(String.format("%s", e.getModel()));
                    }
                }
            });

        }
    }
}
