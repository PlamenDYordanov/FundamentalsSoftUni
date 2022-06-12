package ProgrammingFundamentals.TextProcessing.Lab;

import java.util.Scanner;

public class P01_ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            StringBuilder reversed = new StringBuilder();
            for (int i = input.length() - 1; i >= 0; i--) {
                reversed.append(input.charAt(i));

            }
            System.out.println(String.format("%s = %s",input, reversed.toString()));

            input = scanner.nextLine();

        }

    }
}
