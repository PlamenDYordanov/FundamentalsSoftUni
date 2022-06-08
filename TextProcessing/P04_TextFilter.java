package ProgrammingFundamentals.TextProcessing;

import java.util.Scanner;

public class P04_TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] removedWord = scanner.nextLine().split(", ");
        String input = scanner.nextLine();


        for (String banWord : removedWord) {

            if (input.contains(banWord)){
            String replacementWord = replaceWord("*",banWord.length());
                input = input.replace(banWord, replacementWord);


            }

        }
        System.out.println(input);
    }
    public static String replaceWord (String word, int length){

        String[] wordArr = new String[length];
        for (int i = 0; i < length; i++) {
            wordArr[i] = word;
        }
        return String.join("",wordArr);
    }
}
