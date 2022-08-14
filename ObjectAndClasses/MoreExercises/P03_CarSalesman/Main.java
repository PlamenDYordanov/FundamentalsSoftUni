package ProgrammingFundamentals.ObjectAndClasses.MoreExercises.P03_CarSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Engine> engineList = new ArrayList<>();
        List<Car> carList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] engineSpec = scanner.nextLine().split("\\s+");
            String model = engineSpec[0];
            String hp = engineSpec[1];
            String displacement = "";
            String efficiency = "";
            if (engineSpec.length == 4) {
                displacement = engineSpec[2];
                efficiency = engineSpec[3];
            } else if (engineSpec.length == 3) {
                for (char currChar : engineSpec[2].toCharArray()) {
                    if (Character.isDigit(currChar)) {
                        efficiency = "n/a";
                        displacement = engineSpec[2];
                        break;
                    } else {
                        displacement = "n/a";
                        efficiency = engineSpec[2];
                        break;
                    }
                }
            } else if (engineSpec.length == 2) {
                displacement = "n/a";
                efficiency = "n/a";
            }
            Engine engine = new Engine(model, hp, displacement, efficiency);
            engineList.add(engine);

        }
        int m = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < m; i++) {
            String[] carSpec = scanner.nextLine().split("\\s+");
            String model = carSpec[0];
            String engine = carSpec[1];
            String weight = "";
            String color = "";
            if (carSpec.length == 4) {
                weight = carSpec[2];
                color = carSpec[3];
            } else if (carSpec.length == 3) {
                for (char currChar : carSpec[2].toCharArray()) {
                    if (Character.isDigit(currChar)) {
                        weight = carSpec[2];
                        color = "n/a";
                        break;
                    } else {
                        weight = "n/a";
                        color = carSpec[2];
                        break;
                    }
                }
            } else {
                weight = "n/a";
                color = "n/a";
            }

            Car car = new Car(model, engine, weight, color);
            carList.add(car);
        }
        for (Car car : carList) {
            String currentEngineModel = car.getEngineModel();
            for (Engine engine : engineList) {
                if (currentEngineModel.equals(engine.getModelName())) {
                    System.out.printf("%s:%n", car.getModel());
                    System.out.print(engine.toString());
                    System.out.printf("Weight: %s%n", car.getWeight());
                    System.out.printf("Color: %s%n", car.getColor());
                    break;
                }
            }


        }

    }
}
