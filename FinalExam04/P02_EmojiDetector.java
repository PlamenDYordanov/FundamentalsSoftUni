package ProgrammingFundamentals.FinalExam04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02_EmojiDetector {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String regex = "(?<emoji>(?<delimeter>[:]{2}|[*]{2})(?<name>[A-Z][a-z]{2,})\\2)";
        String regexDigits = "(?<digit>[0-9])";

        Pattern pattern = Pattern.compile(regex);
        Pattern digits = Pattern.compile(regexDigits);
        List<String> listOfCoolEmoji = new ArrayList<>();

        String input = scanner.nextLine();
        Matcher matcherEmoji = pattern.matcher(input);
        Matcher matcherDigits = digits.matcher(input);

        int threshold = 1;
        while (matcherDigits.find()) {

            threshold *= Integer.parseInt(matcherDigits.group("digit"));
        }
        System.out.printf("Cool threshold: %d%n", threshold);
        int counter = 0;

        while (matcherEmoji.find()) {
            counter++;
            String currentEmoji = matcherEmoji.group("name");
            int currentCool = 0;
            for (char symbol : currentEmoji.toCharArray()) {
                currentCool += (int) symbol;
            }
            if (threshold < currentCool) {
                listOfCoolEmoji.add(matcherEmoji.group("emoji"));
            }


        }

            System.out.printf("%d emojis found in the text. The cool ones are:%n", counter);

            System.out.print(String.join(System.lineSeparator(), listOfCoolEmoji));


    }
}
