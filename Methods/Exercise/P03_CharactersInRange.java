package ProgrammingFundamentals.Methods_Ex;

import java.util.Scanner;

public class P03_CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char firstChar = scanner.nextLine().charAt(0);
        char secondChar = scanner.nextLine().charAt(0);

        System.out.println(printSequenceChars(firstChar, secondChar));
    }

    public static String printSequenceChars(char firstChar, char secondChar) {
        char currentChar = ' ';
        String sequenceOfChars = "";
        if (firstChar < secondChar) {
            for (int i = firstChar + 1; i < secondChar; i++) {
                currentChar = (char) i;
                sequenceOfChars += currentChar + " ";

            }
            return sequenceOfChars;
        } else {
            for (int i = secondChar + 1; i < firstChar; i++) {
                currentChar = (char) i;
                sequenceOfChars += currentChar + " ";
            }
        }
        return sequenceOfChars;
    }
}
