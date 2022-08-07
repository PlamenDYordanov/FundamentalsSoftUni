package ProgrammingFundamentals.FinalExam;

import java.util.*;

public class P03_DegustationParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> mapLike = new LinkedHashMap<>();


        String input = scanner.nextLine();
        int counter = 0;
        while (!input.equals("Stop")) {
            String command = input.split("-")[0];
            String guest = input.split("-")[1];
            String meal = input.split("-")[2];

            switch (command) {

                case "Like": {
                    if (!mapLike.containsKey(guest)) {
                        mapLike.put(guest, new ArrayList<>());
                        mapLike.get(guest).add(meal);

                    } else {
                        List<String> meals = mapLike.get(guest);
                        if (!meals.contains(meal)) {
                            mapLike.get(guest).add(meal);
                        }
                    }
                }
                break;
                case "Dislike":
                    if (!mapLike.containsKey(guest)) {
                        System.out.printf("%s is not at the party.%n", guest);
                    } else {
                        List<String> meals = mapLike.get(guest);
                        if (meals.contains(meal)) {
                            mapLike.get(guest).remove(meal);
                            System.out.printf("%s doesn't like the %s.%n", guest, meal);
                            counter++;
                        } else {
                            System.out.printf("%s doesn't have the %s in his/her collection.%n", guest, meal);
                        }

                    }
                    break;
            }


            input = scanner.nextLine();
        }
        for (Map.Entry<String, List<String>> entry : mapLike.entrySet()) {
            if (entry.getValue().size() > 1) {
                System.out.printf("%s: %s%n", entry.getKey(), String.join(", ", entry.getValue()));
            }else {
                String currentMeal = entry.getValue().toString();
              currentMeal =   currentMeal.replaceAll("[\\[\\]]", "");
                System.out.printf("%s: %s%n", entry.getKey(), currentMeal);
            }
        }
        System.out.printf("Unliked meals: %d", counter);

    }
}
