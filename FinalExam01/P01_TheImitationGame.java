package ProgrammingFundamentals.FinalExam01;

import java.util.Scanner;

public class P01_TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String decryptedText = scanner.nextLine();

        String input = scanner.nextLine();

        while (!input.equals("Decode")) {
            String[] tokens = input.split("\\|");
            String command = input.split("\\|")[0];
            String firstPart = "";
            String secondPart = "";
            switch (command) {
                case "ChangeAll":
                    String substring = tokens[1];
                    String replacement = tokens[2];
                    decryptedText = decryptedText.replace(substring, replacement);
                    break;
                case "Insert":
                    int index = Integer.parseInt(tokens[1]);
                    String value = tokens[2];
                    firstPart = decryptedText.substring(0, index);
                    secondPart = decryptedText.substring(index);
                    decryptedText = (firstPart).concat(value).concat(secondPart);
                    break;
                case "Move":
                    int numberOfLetters = Integer.parseInt(tokens[1]);
                    firstPart = decryptedText.substring(0, numberOfLetters);
                    secondPart = decryptedText.substring(numberOfLetters);
                    decryptedText = secondPart.concat(firstPart);
                    break;
            }


            input = scanner.nextLine();
        }
        System.out.printf("The decrypted message is: %s%n",decryptedText);
    }
}
