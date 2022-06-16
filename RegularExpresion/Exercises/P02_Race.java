package ProgrammingFundamentals.RegularExpresion.Exercises;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class P02_Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] participants = scanner.nextLine().split(", ");


        String regexName = "[A-Za-z]+";
        String regexDistance = "[0-9]";
        Pattern patternName = Pattern.compile(regexName);
        Pattern patternDistance = Pattern.compile(regexDistance);

        String input = scanner.nextLine();
        Map<String, Integer> participantsDistance = new LinkedHashMap<>();
        boolean isExist = false;
        while (!input.equals("end of race")) {
            StringBuilder name = new StringBuilder();
            int totalDistance = 0;


            for (int i = 0; i < input.length(); i++) {
                char symbol = input.charAt(i);
                String charString = String.valueOf(symbol);
                Matcher names = patternName.matcher(charString);
                Matcher distance = patternDistance.matcher(charString);
                if (names.find()) {
                    name.append(names.group());
                }
                if (distance.find()) {
                    totalDistance += Integer.parseInt(distance.group());
                }

            }
            String nameOfRacer = String.valueOf(name);
            for (int i = 0; i < participants.length; i++) {
                if (participants[i].equals(nameOfRacer)) {
                    isExist = true;
                }
            }
            if (isExist) {
                if (!participantsDistance.containsKey(nameOfRacer)) {
                    participantsDistance.put(nameOfRacer, totalDistance);
                } else {
                    int currentDistance = participantsDistance.get(nameOfRacer);
                    participantsDistance.put(nameOfRacer, currentDistance + totalDistance);
                }
                isExist = false;
            }
            nameOfRacer = "";
            input = scanner.nextLine();
        }

        List<String> firstThreeNames = participantsDistance.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());

        System.out.printf("1st place: %s%n", firstThreeNames.get(0));
        System.out.printf("2nd place: %s%n", firstThreeNames.get(1));
        System.out.printf("3rd place: %s%n", firstThreeNames.get(2));

    }
}
