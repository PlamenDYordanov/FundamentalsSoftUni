package ProgrammingFundamentals.TextProcessing.Exercises;

import java.util.Scanner;

public class P01_ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] usernames = input.split(", ");

        for (String username : usernames) {

            if (isValid(username)){
                System.out.println(username);
            }
        }
    }

    public static boolean isValid(String username) {
        if (username.length() < 3 || username.length() > 16) {
            return false;
        }
        for (int i = 0; i < username.length(); i++) {
            char symbol = username.charAt(i);
            if (symbol == '-' || symbol == '_'){
                continue;
            }
            if (!Character.isLetterOrDigit(symbol) ){
                return false;
            }
        }
        return true;
    }
}
