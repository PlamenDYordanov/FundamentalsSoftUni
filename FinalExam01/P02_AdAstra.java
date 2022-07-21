package ProgrammingFundamentals.FinalExam01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02_AdAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String regex = "(?<delimeter>[#|]?)(?<product>[A-Za-z\\s]+)\\1(?<expiration>[0-9]{2}\\/[0-9]{2}\\/[0-9]{2})\\1(?<cal>[0-9]+)\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        List<String> items = new ArrayList<>();
        List<String> date = new ArrayList<>();
        List<String> call = new ArrayList<>();

        int totalCal = 0;

        while (matcher.find()) {
            int currentCal = Integer.parseInt(matcher.group("cal"));
            totalCal += currentCal;
            items.add(matcher.group("product"));
            date.add(matcher.group("expiration"));
            call.add(matcher.group("cal"));
        }
        int daysFood = totalCal/2000;

        System.out.printf("You have food to last you for: %d days!%n",daysFood);
        for (int i = 0; i < items.size(); i++) {
            System.out.printf("Item: %s, Best before: %s, Nutrition: %s%n",items.get(i),date.get(i),call.get(i));
        }
    }
}
