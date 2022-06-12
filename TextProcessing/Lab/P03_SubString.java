package ProgrammingFundamentals.TextProcessing.Lab;

import java.util.Scanner;

public class P03_SubString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String removeWord = scanner.nextLine();
        String word = scanner.nextLine();

        int index = word.indexOf(removeWord);

        while (index >= 0) {

            word = word.replace(removeWord, "");
            index = word.indexOf(removeWord);
        }


        System.out.println(word);
    }
}
