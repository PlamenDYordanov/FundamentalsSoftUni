package ProgrammingFundamentals.FinalExam04;

import java.util.*;

public class P03_Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\|\\|");
        Map<String, Integer> mapOfPeople = new LinkedHashMap<>();
        Map<String, Integer> mapOfGold = new LinkedHashMap<>();

        while (!input[0].equals("Sail")) {
            String name = input[0];
            int people = Integer.parseInt(input[1]);
            int gold = Integer.parseInt(input[2]);

            if (!mapOfGold.containsKey(name)) {
                mapOfGold.put(name, gold);
                mapOfPeople.put(name, people);
            } else {
                int currentGold = mapOfGold.get(name);
                int currentPeople = mapOfPeople.get(name);
                mapOfPeople.put(name, currentPeople + people);
                mapOfGold.put(name, currentGold + gold);
            }

            input = scanner.nextLine().split("\\|\\|");

        }

        String[] commandLine = scanner.nextLine().split("=>");
        while (!commandLine[0].equals("End")) {
            String command = commandLine[0];
            String name = commandLine[1];

            switch (command) {
                case "Plunder": {
                    int people = Integer.parseInt(commandLine[2]);
                    int gold = Integer.parseInt(commandLine[3]);
                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", name, gold, people);
                    if (!getNewPopulation(mapOfPeople, people, name)) {
                        mapOfPeople.remove(name);
                        mapOfGold.remove(name);
                        System.out.printf("%s has been wiped off the map!%n", name);
                        break;
                    } else {
                        int currPeople = mapOfPeople.get(name);
                        mapOfPeople.put(name, currPeople - people);
                    }
                    if (!getNewAmountOfGold(mapOfGold, gold, name)) {
                        mapOfGold.remove(name);
                        mapOfPeople.remove(name);
                        System.out.printf("%s has been wiped off the map!%n", name);
                        break;
                    } else {
                        int currGold = mapOfGold.get(name);
                        mapOfGold.put(name, currGold - gold);
                    }

                }
                break;
                case "Prosper":
                    int gold = Integer.parseInt(commandLine[2]);
                    if (gold >= 0) {
                        int currGold = mapOfGold.get(name);
                        mapOfGold.put(name, currGold + gold);
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", gold, name, currGold + gold);
                    } else {
                        System.out.println("Gold added cannot be a negative number!");
                    }
                    break;
            }

            commandLine = scanner.nextLine().split("=>");
        }
        if (mapOfGold.size() > 0) {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", mapOfGold.size());
            List<Integer> listOfGold = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : mapOfGold.entrySet()) {
                listOfGold.add(entry.getValue());
            }
            int i = 0;
            for (Map.Entry<String, Integer> entry : mapOfPeople.entrySet()) {
                System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n", entry.getKey(), entry.getValue(), listOfGold.get(i));
                i++;
            }
        }else {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        }


    }

    private static boolean getNewAmountOfGold(Map<String, Integer> mapOfGold, int gold, String name) {
        int currentGold = mapOfGold.get(name);
        if (currentGold - gold <= 0) {
            return false;
        }
        return true;
    }

    private static boolean getNewPopulation(Map<String, Integer> mapOfPeople, int people, String name) {
        int currentPeople = mapOfPeople.get(name);
        if (currentPeople - people <= 0) {
            return false;
        }
        return true;

    }
}
