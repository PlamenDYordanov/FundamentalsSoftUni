package ProgrammingFundamentals.FinalExam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02_Decrypt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String regex = "^^((?<delimeter1>[$%])(?<tag>[A-Z][a-z]{2,})\\2: (\\[([0-9]+)\\]\\|){1,3})$";

        for (int i = 0; i < n; i++) {
            StringBuilder digit = new StringBuilder();
            StringBuilder symbols = new StringBuilder();

            String input = scanner.nextLine();
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()){
                for (char curSymbol:input.toCharArray()) {
                    if (curSymbol == ']'){
                        int integer = Integer.parseInt(digit.toString());
                        char symbol = (char)  integer;
                        symbols.append(symbol);
                        digit = new StringBuilder("");
                    }
                    if (Character.isDigit(curSymbol)) {
                            digit.append(curSymbol);

                    }
                }
                System.out.printf("%s: %s%n",matcher.group("tag"),symbols.toString());

            }else {
                System.out.println("Valid message not found!");
            }


        }
    }
}
