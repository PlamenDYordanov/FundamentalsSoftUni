package ProgrammingFundamentals.FinalExam;

import java.util.Scanner;

public class P01_Password {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();

        StringBuilder newPassword = new StringBuilder(password);

        String commands = scanner.nextLine();
        while (!commands.equals("Complete")) {
            String currentCommands = commands;
            int index = 0;

            if (currentCommands.contains("Make Upper")) {
                index = Integer.parseInt(currentCommands.split(" ")[2]);
                char symbol = Character.toUpperCase(password.charAt(index));
                newPassword.deleteCharAt(index).insert(index, symbol);
                System.out.println(newPassword);

            } else if (currentCommands.contains("Make Lower")) {
                index = Integer.parseInt(currentCommands.split(" ")[2]);
                char symbol = Character.toLowerCase(newPassword.charAt(index));
                newPassword.deleteCharAt(index).insert(index, symbol);
                System.out.println(newPassword);

            } else if (currentCommands.contains("Insert")) {
                index = Integer.parseInt(currentCommands.split(" ")[1]);
                String symbol = currentCommands.split(" ")[2];

                if (index >= 0 && index <= newPassword.length()) {
                    newPassword.insert(index, symbol);
                    System.out.println(newPassword);
                }

            } else if (currentCommands.contains("Replace")) {
                char currentSymbol = currentCommands.split(" ")[1].charAt(0);
                int value = Integer.parseInt(currentCommands.split(" ")[2]);
                int sumASCII = 0;
                sumASCII = currentSymbol + value;
                char newSymbol = (char) sumASCII;
                String charToReplace = Character.toString(newSymbol);
                password = newPassword.toString().replace(currentSymbol, newSymbol);
                newPassword = new StringBuilder(password);
                System.out.println(password);

            } else if (currentCommands.contains("Validation")) {
                password = newPassword.toString();
                if (password.length() < 8) {
                    System.out.println("Password must be at least 8 characters long!");
                }

                for (char symbol : password.toCharArray()) {
                    if (!Character.isLetterOrDigit(symbol) && symbol != '_') {
                        System.out.println("Password must consist only of letters, digits and _!");
                    }
                }

                int countIsUpperCase = 0;
                for (char symbol : password.toCharArray()) {
                    if (Character.isUpperCase(symbol)) {
                        countIsUpperCase++;
                    }
                }
                if (countIsUpperCase < 1) {
                    System.out.println("Password must consist at least one uppercase letter!");
                }

                int countIsLowerCase = 0;
                for (char symbol : password.toCharArray()) {
                    if (Character.isLowerCase(symbol)) {
                        countIsLowerCase++;
                    }
                }
                if (countIsLowerCase < 1) {
                    System.out.println("Password must consist at least one lowercase letter!");
                }

                int countDigits = 0;
                for (char symbol : password.toCharArray()) {
                    if (Character.isDigit(symbol)) {
                        countDigits++;
                    }
                }
                if (countDigits < 1) {
                    System.out.println("Password must consist at least one digit!");
                }
            }

            commands = scanner.nextLine();
        }
    }
}

