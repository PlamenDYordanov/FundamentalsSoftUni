package ProgrammingFundamentals.RegularExpresion.Exercises;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P04_StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());


        Map<String, List<String>> planets = new LinkedHashMap<>();
        planets.put("Attacked planets", new ArrayList<>());
        planets.put("Destroyed planets", new ArrayList<>());


        for (int i = 1; i <= count; i++) {
            String input = scanner.nextLine();

            input = getNewString(input);

            String regex = "@(?<planetName>[A-za-z]+)[^-@!:>]*:(?<population>\\d+)[^-@!:>]*!(?<type>[AD])![^-@!:>]*->(?<soldiers>\\d+)";

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {
                String planetName = matcher.group("planetName");
                String type = matcher.group("type");

                if (type.equals("A")) {

                    planets.get("Attacked planets").add(planetName);

                } else {

                    planets.get("Destroyed planets").add(planetName);

                }

            }


        }
        for (Map.Entry<String, List<String>> entry : planets.entrySet()) {
            System.out.println(String.format("%s: %d", entry.getKey(), entry.getValue().size()));
            entry.getValue().stream().sorted(String::compareTo).forEach(e -> System.out.println(String.format("-> %s", e)));

        }


    }

    private static String getNewString(String input) {
        StringBuilder newInput = new StringBuilder();
        int subtract = 0;

        String lowerCase = input.toLowerCase();
        for (int j = 0; j < lowerCase.length(); j++) {
            char symbol = lowerCase.charAt(j);

            if (symbol == 's' || symbol == 't' || symbol == 'a' ||
                    symbol == 'r') {
                subtract++;
            }
        }
        for (int j = 0; j < input.length(); j++) {
            char symbol = input.charAt(j);
            int asciiNum = (char) symbol - subtract;
            char newSymbol = (char) asciiNum;
            newInput.append(newSymbol);
        }
        return input = String.valueOf(newInput);

    }
}
