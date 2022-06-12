package ProgrammingFundamentals.TextProcessing.Exercises;

import java.util.Scanner;

public class P02_CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] multiplyStrings = input.split(" ");

        int result = getSumOfChars(multiplyStrings);
        System.out.println(result);
    }

    private static int getSumOfChars(String[] multiplyStrings) {
        int totalSum = 0;
        String firstInput = multiplyStrings[0];
        String secondInput = multiplyStrings[1];
        int maxLength = Math.min(firstInput.length(), secondInput.length());

        for (int i = 0; i < maxLength; i++) {
            char firstChar = firstInput.charAt(i);
            char secondChar = secondInput.charAt(i);
            int firstAsciiNum = (int) firstChar;
            int secondAsciiNum = (int) secondChar;
            int sum = firstAsciiNum * secondAsciiNum;
            totalSum += sum;
        }
        if (firstInput.length() > secondInput.length()) {
            for (int i = maxLength ; i < firstInput.length(); i++) {
                char firstChar = firstInput.charAt(i);
                int firstAsciiNum = (int) firstChar;
                totalSum += firstAsciiNum;
            }
        } else if (secondInput.length() > firstInput.length()) {
            for (int i = maxLength ; i < secondInput.length(); i++) {
                char secondChar = secondInput.charAt(i);
                int secondAsciiNum = (int) secondChar;
                totalSum += secondAsciiNum;
            }
        }
        return totalSum;
    }

}
