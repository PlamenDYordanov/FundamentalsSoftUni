package ProgrammingFundamentals.FinalExam02;

import java.util.*;

public class P03_PlantDiscovery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Double>> mapOfRatting = new LinkedHashMap<>();
        Map<String, Integer> mapOfRarity = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String name = input.split("<->")[0];
            int rarity = Integer.parseInt(input.split("<->")[1]);
            mapOfRarity.compute(name, (k, v) -> rarity);
            mapOfRatting.putIfAbsent(name, new ArrayList<>());
        }

        String input = scanner.nextLine();
        while (!input.equals("Exhibition")) {
            String command = input.split(": ")[0];
            String splitInput = input.split(": ")[1];

            switch (command) {
                case "Rate": {
                    String name = splitInput.split(" - ")[0];
                    double ratting = Double.parseDouble(splitInput.split(" - ")[1]);

                    if (mapOfRatting.containsKey(name)) {
                        mapOfRatting.get(name).add(ratting);
                    } else {
                        System.out.println("error");
                    }
                    break;
                }
                case "Update": {
                    String name = splitInput.split(" - ")[0];
                    int newRarity = Integer.parseInt(splitInput.split(" - ")[1]);

                    if (mapOfRarity.containsKey(name)) {
                        mapOfRarity.put(name, newRarity);
                    } else {
                        System.out.println("error");
                    }
                }
                break;
                case "Reset":
                    String name = splitInput.split(" - ")[0];

                    if (mapOfRatting.containsKey(name)) {
                        mapOfRatting.get(name).clear();
                    } else {
                        System.out.println("error");
                    }
                    break;
            }
            input = scanner.nextLine();
        }


        List<Double> averageRatting = new ArrayList<>();
        for (Map.Entry<String, List<Double>> entry : mapOfRatting.entrySet()) {
            if (entry.getValue().size() > 0) {
                double average = entry.getValue().stream().mapToDouble(e -> e).average().getAsDouble();
                averageRatting.add(average);
            } else {
                double average = 0.0;
                averageRatting.add(average);
            }
        }

        System.out.println("Plants for the exhibition:");
        int i = 0;
        for (Map.Entry<String, Integer> entry : mapOfRarity.entrySet()) {
            System.out.printf("- %s; Rarity: %d; Rating: %.2f%n", entry.getKey(), entry.getValue(), averageRatting.get(i));
            i++;
        }


    }
}

