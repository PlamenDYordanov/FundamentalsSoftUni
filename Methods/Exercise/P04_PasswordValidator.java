package ProgrammingFundamentals.Methods_Ex;

import java.util.Scanner;

public class P04_PasswordValidator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();

        if (!hasItRequireLength(password)){
            System.out.println("Password must be between 6 and 10 characters");
        }
        if (!hasItLettersAndDigits(password)){
            System.out.println("Password must consist only of letters and digits");
        }
        if (!hasItAtLeast2Digits(password)){
            System.out.println("Password must have at least 2 digits");
        }
        if (hasItAtLeast2Digits(password)&&hasItLettersAndDigits(password)&&
        hasItRequireLength(password)){
            System.out.println("Password is valid");
        }

    }

    public static boolean hasItRequireLength(String password) {
        if (password.length() >= 6 && password.length() <= 10) {
            return true;
        }
        return false;
    }

    public static boolean hasItLettersAndDigits(String password) {
        for (char currentChar : password.toCharArray()) {
            if (!Character.isLetterOrDigit(currentChar)) {
                return false;
            }
        }
        return true;
    }

    public static boolean hasItAtLeast2Digits(String password) {
        int counter = 0;
        for (int i = 0; i < password.length(); i++) {
            char currentChar = password.charAt(i);
            if (Character.isDigit(currentChar)) {
                    counter++;
            }
        }
        if (counter>=2){
            return true;
        }else {
            return false;
        }
    }
}
