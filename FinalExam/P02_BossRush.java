package ProgrammingFundamentals.FinalExam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02_BossRush {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String regex = "^([|])(?<boss>[A-Z]{4,})\\1:([#])(?<title>[A-Za-z]+ [A-Za-z]+)\\3$";
        Pattern pattern = Pattern.compile(regex);
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()){
            String name = matcher.group("boss");
            int lengthName = name.length();
            String title = matcher.group("title");
            int lengthTitle = title.length();
                System.out.printf("%s, The %s%n",matcher.group("boss"), matcher.group("title"));
                System.out.printf(">> Strength: %d%n",lengthName);
                System.out.printf(">> Armor: %d%n",lengthTitle);
            }else {
                System.out.println("Access denied!");
            }

        }
    }
}
