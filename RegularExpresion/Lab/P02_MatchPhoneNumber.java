package ProgrammingFundamentals.RegularExpresion.Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02_MatchPhoneNumber {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<String> phoneNumbers = new ArrayList<>();

        String regex = "\\+359+(?<separator>[ -])2\\1[0-9]{3}\\1[0-9]{4}\\b";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(input);
        while (matcher.find()){
            phoneNumbers.add(matcher.group());
        }

        System.out.print(String.join(", ",phoneNumbers));


    }
}
