package ProgrammingFundamentals.Methods_Ex;

import java.util.Scanner;

public class P09_PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("END")) {

            boolean result  = whetherTheNumberIsPalindrome(input);
            System.out.println(result);

            input = scanner.nextLine();
        }
    }

    public static boolean whetherTheNumberIsPalindrome(String input) {
        String backwardsInput = "";

        for (int i = input.length() - 1; i >= 0; i--) {
            char currentChar = input.charAt(i);
            backwardsInput+=currentChar;
        }
        return backwardsInput.equals(input);
    }
}
