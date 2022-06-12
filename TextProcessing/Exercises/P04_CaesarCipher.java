package ProgrammingFundamentals.TextProcessing.Exercises;

import java.util.Scanner;

public class P04_CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();



        System.out.println(getEncrypt(input).toString());

    }

    private static StringBuilder getEncrypt(String text) {
        StringBuilder encryptedCode = new StringBuilder();



            for (int i = 0; i < text.length(); i++) {
                int charAscii = (char) text.charAt(i);
                char newChar = (char) ( charAscii+3);
                encryptedCode.append(newChar);


        }
        return encryptedCode;
    }
}
