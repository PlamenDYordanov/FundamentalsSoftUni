package ProgrammingFundamentals.FinalExam03;

import java.time.temporal.IsoFields;
import java.util.Scanner;

public class P01_PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();
        String input = scanner.nextLine();

        while (!input.equals("Done")) {

            String command = input.split(" ")[0];

            switch (command) {
                case "TakeOdd":
                    password = newStringAfterTakeOdd(password);
                    System.out.println(password);
                    break;
                case "Cut":
                    int index = Integer.parseInt(input.split(" ")[1]);
                    int length = Integer.parseInt(input.split(" ")[2]);
                    String firstPart = password.substring(0, index);
                    String cutText = password.substring(index, index + length);
                    String secondPart = password.substring(index + length);
                    password = firstPart.concat(secondPart);
                    System.out.println(password);
                    break;
                case "Substitute":
                    String sub = input.split(" ")[1];
                    String replace = input.split(" ")[2];
                    if (password.contains(sub)) {
                        password = password.replace(sub, replace);
                        System.out.println(password);
                    } else {
                        System.out.println("Nothing to replace!");
                    }
                    break;

            }

            input = scanner.nextLine();
        }
        System.out.printf("Your password is: %s",password);
    }

    private static String newStringAfterTakeOdd(String password) {
        StringBuilder newString = new StringBuilder();
        for (int i = 1; i < password.length(); i += 2) {
            char currChar = password.charAt(i);
            newString.append(currChar);
        }
        return password = String.valueOf(newString);
    }
}
