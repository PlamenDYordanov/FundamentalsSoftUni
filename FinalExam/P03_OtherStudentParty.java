package ProgrammingFundamentals.FinalExam;

import java.util.*;

public class P03_OtherStudentParty {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, List<String>> mapMeal = new LinkedHashMap<>();

        int countUnlikedMeals = 0;
        String input = scanner.nextLine();
        int counter = 0;
        while (!input.equals("Stop")) {

            String[] commands = input.split("-");
            String command = commands[0];
            String guest = commands[1];
            String meal = commands[2];
            if (command.equals("Like")) {
                if (!mapMeal.containsKey(guest)) {
                    mapMeal.put(guest, new ArrayList<>());
                    mapMeal.get(guest).add(meal);

                } else {
                    List<String> meals = mapMeal.get(guest);
                    if (!meals.contains(meal)) {
                        mapMeal.get(guest).add(meal);
                    }
                }
            } else if (command.equals("Dislike")) {
                if (!mapMeal.containsKey(guest)) {
                    System.out.printf("%s is not at the party.%n", guest);
                } else {
                    List<String> meals = mapMeal.get(guest);
                    if (meals.contains(meal)) {
                        mapMeal.get(guest).remove(meal);
                        System.out.printf("%s doesn't like the %s.%n", guest, meal);
                        counter++;
                    } else {
                        System.out.printf("%s doesn't have the %s in his/her collection.%n", guest, meal);
                    }

                }

            }
            input = scanner.nextLine();
        }
        for (Map.Entry<String, List<String>> entry : mapMeal.entrySet()) {
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





