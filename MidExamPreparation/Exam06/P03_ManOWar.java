package ProgrammingFundamentals.MidExamPreparation.Exam06;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03_ManOWar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> pirateShip = Arrays
                .stream(scanner.nextLine().split(">"))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> warship = Arrays
                .stream(scanner.nextLine().split(">"))
                .map(Integer::parseInt).collect(Collectors.toList());

        int maxHealth = Integer.parseInt(scanner.nextLine());
        int index = 0;
        int damage = 0;
        String inputLine = scanner.nextLine();
        String command = "";
        boolean isSunk = false;
        while (!inputLine.equals("Retire")) {
            String[] arrInput = inputLine.split(" ");
            command = arrInput[0];


            switch (command) {
                case "Fire":
                    index = Integer.parseInt(arrInput[1]);
                    damage = Integer.parseInt(arrInput[2]);
                   if (getInformationAfterFire(warship, index, damage)){
                       isSunk = true;
                       break;
                   }
                    break;
                case "Defend":
                    int startIndex = Integer.parseInt(arrInput[1]);
                    int endIndex = Integer.parseInt(arrInput[2]);
                    damage = Integer.parseInt(arrInput[3]);
                   if (getInformationAfterDefend(pirateShip, startIndex, endIndex, damage)){
                       isSunk = true;
                       break;
                   }
                    break;
                case "Repair":
                    index = Integer.parseInt(arrInput[1]);
                    int health = Integer.parseInt(arrInput[2]);
                    getInformationAfterHelath(pirateShip, index, health, maxHealth);
                    break;
                case "Status":
                    printStatusInformation(pirateShip, maxHealth);
                    break;
            }
            if (isSunk){
                break;
            }

            inputLine = scanner.nextLine();
        }
        if (inputLine.equals("Retire")) {
            getStatusOfShips(pirateShip, warship);
        }
    }

    private static void getStatusOfShips(List<Integer> pirateShip, List<Integer> warship) {
        int pirateSum = 0;
        int warshipSum = 0;
        for (Integer integer : pirateShip) {
            pirateSum += integer;
        }
        for (Integer integer : warship) {
            warshipSum += integer;
        }
        System.out.printf("Pirate ship status: %d%n", pirateSum);
        System.out.printf("Warship status: %d%n", warshipSum);

    }

    private static void printStatusInformation(List<Integer> pirateShip, int maxHealth) {
        double checkHealth = maxHealth * 0.20;
        int counter = 0;
        for (int i = 0; i < pirateShip.size(); i++) {
            if (pirateShip.get(i) < checkHealth) {
                counter++;
            }
        }
        System.out.printf("%d sections need repair.%n", counter);
    }


    private static List<Integer> getInformationAfterHelath(List<Integer> pirateShip, int index, int health, int maxHealth) {
        if (index >= 0 && index <= pirateShip.size() - 1) {
            if (pirateShip.get(index) + health >= maxHealth) {
                pirateShip.set(index, maxHealth);
            } else {
                pirateShip.set(index, pirateShip.get(index) + health);
            }
        }
        return pirateShip;
    }

    private static boolean getInformationAfterDefend(List<Integer> pirateShip, int startIndex, int endIndex, int damage) {
        boolean isSunk = false;
        if (startIndex >= 0 && endIndex <= pirateShip.size() - 1) {
            for (int i = startIndex; i <= endIndex; i++) {
                int currentStat = pirateShip.get(i);
                pirateShip.set(i, currentStat - damage);
                if (pirateShip.get(i) <= 0) {
                    System.out.println("You lost! The pirate ship has sunken.");
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean getInformationAfterFire(List<Integer> warship, int index, int damage) {
        if (index >= 0 && index <= warship.size() - 1) {
            warship.set(index, warship.get(index) - damage);
            if (warship.get(index) <= 0) {
                System.out.println("You won! The enemy ship has sunken.");
                return true;
            }
        }
        return false;
    }
}
