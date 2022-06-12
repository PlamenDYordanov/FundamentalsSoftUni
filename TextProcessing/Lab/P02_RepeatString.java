package ProgrammingFundamentals.TextProcessing.Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P02_RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] wordArr = scanner.nextLine().split("\\s+");

        List<String> concatWord = new ArrayList<>();
        for (String s : wordArr) {
            String result = repeatWord(s,s.length());
            concatWord.add(result);
        }
        System.out.print(String.join("",concatWord));
    }

    private static String repeatWord(String word, int length) {
        String[] newWord = new String[length];
        for (int i = 0; i < length; i++) {

            newWord[i] = word;
        }
        return String.join("",newWord);

    }
}
