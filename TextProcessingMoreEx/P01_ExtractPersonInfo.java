package ProgrammingFundamentals.TextProcessingMoreEx;

import java.util.Scanner;

public class P01_ExtractPersonInfo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());


        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            int firstNameIndex = input.indexOf('@');
            int lastNameIndex = input.indexOf('|');
            int firstYearIndex = input.indexOf('#');
            int lastYearIndex = input.indexOf('*');
            String name = input.substring(firstNameIndex + 1, lastNameIndex);
            String years = input.substring(firstYearIndex + 1, lastYearIndex);
            System.out.printf("%s is %s years old.%n", name, years);

        }
    }
}
