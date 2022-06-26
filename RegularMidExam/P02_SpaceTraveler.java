package ProgrammingFundamentals.RegularMidExam;

import com.sun.security.jgss.GSSUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02_SpaceTraveler {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> routeToTitan =
                Arrays.stream(scanner.nextLine().split("\\|\\|")).collect(Collectors.toList());
        System.out.println();
        int startFuel = Integer.parseInt(scanner.nextLine());
        int ammunition = Integer.parseInt(scanner.nextLine());
        String inputLine = routeToTitan.get(0);
        int index = 0;
        boolean isMissionFailed = false;
        while (!inputLine.equals("Titan")) {
            String[] commands = inputLine.split(" ");
            String command = commands[0];

            switch (command) {
                case "Travel":
                    int lightYears = Integer.parseInt(commands[1]);
                    if (lightYears <= startFuel) {
                        System.out.printf("The spaceship travelled %d light-years.%n", lightYears);
                        startFuel -= lightYears;
                    } else {
                        System.out.println("Mission failed.");
                        startFuel = 0;
                        isMissionFailed = true;
                    }
                    if (isMissionFailed) {
                        break;
                    }
                    break;
                case "Enemy":
                    int enemyArmour = Integer.parseInt(commands[1]);
                    if (ammunition >= enemyArmour) {
                        ammunition -= enemyArmour;
                        System.out.printf("An enemy with %d armour is defeated.%n", enemyArmour);

                    } else {
                        int neededFuel = enemyArmour * 2;
                        if (neededFuel <= startFuel) {
                            startFuel -= neededFuel;
                            System.out.printf("An enemy with %d armour is outmaneuvered.%n", enemyArmour);

                        } else {
                            isMissionFailed = true;
                            System.out.println("Mission failed.");
                        }
                        if (isMissionFailed) {
                            break;
                        }

                    }
                    break;
                case "Repair":
                    int ammunitionAndFuel = Integer.parseInt(commands[1]);
                    ammunition += ammunitionAndFuel * 2;
                    System.out.printf("Ammunitions added: %d.%n", ammunitionAndFuel * 2);
                    startFuel += ammunitionAndFuel;
                    System.out.printf("Fuel added: %d.%n", ammunitionAndFuel);
                    break;
            }

            if (isMissionFailed){
                break;
            }

            index++;
            inputLine = routeToTitan.get(index);

        }
        if (!isMissionFailed) {
            System.out.println("You have reached Titan, all passengers are safe.");
        }

    }


}
