package ProgrammingFundamentals.FinalExam02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02_DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String regex = "(?<delimeter>[=\\/])(?<destination>[A-Z][A-Za-z]{2,})\\1";
        List<String> destination = new ArrayList<>();

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        int totalPoints = 0;
        while (matcher.find()){
            destination.add(matcher.group("destination"));
            int currentLength = matcher.group("destination").length();
            totalPoints += currentLength;
        }
        System.out.print("Destinations: ");
        System.out.println(String.join(", ",destination));
        System.out.printf("Travel Points: %d",totalPoints);
    }
}
