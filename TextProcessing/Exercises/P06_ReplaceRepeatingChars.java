package ProgrammingFundamentals.TextProcessing.Exercises;

import java.util.Scanner;

public class P06_ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        char oldChar = ' ';
        for (int i = 0; i < input.length(); i++) {
            if (i==0){
                oldChar = input.charAt(i);
                System.out.print(oldChar);
                continue;
            }
            if (oldChar!=input.charAt(i)){
                System.out.print(input.charAt(i));
            }
            oldChar=input.charAt(i);
        }
    }
}
