package ProgrammingFundamentals.ConditionalStatementsLoopsExercises;

import java.util.Scanner;

public class P05_Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String password = "";
        int length = text.length();
        int counter = 0;
        boolean isBlocked = false;
        for (int i = 1; i <= length; i++) {
            char lastSymbol = text.charAt(length - i);
            password += lastSymbol;

        }
            String input =scanner.nextLine();
        while (!password.equals(input)) {
            counter++;
            if (counter > 3) {
                isBlocked = true;
                break;
            }
            System.out.println("Incorrect password. Try again.");
            input = scanner.nextLine();
        }
        if (isBlocked){
            System.out.printf("User %s blocked!",text);
        }else {
            System.out.printf("User %s logged in.",text);
        }
    }
}
