package ProgrammingFundamentals.TextProcessingMoreEx;

import java.util.Scanner;

public class P04_MorseCode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] morseCode = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-",
                ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P",
                "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

        StringBuilder decryptMorse = new StringBuilder();
        String[] input = scanner.nextLine().split(" \\| ");

        for (int i = 0; i < input.length; i++) {
            int index = 0;
            String mores = input[i];
            String[] alphabetFromMorse = mores.split(" ");
            for (int j = 0; j < alphabetFromMorse.length; j++) {
                String curMorse = alphabetFromMorse[j];
                for (int k = 0; k < morseCode.length; k++) {
                    if (curMorse.equals(morseCode[k])) {
                        decryptMorse.append(alphabet[k]);
                        break;
                    }

                }
            }
            decryptMorse.append(" ");
        }
        System.out.println(decryptMorse.toString());
    }
}
