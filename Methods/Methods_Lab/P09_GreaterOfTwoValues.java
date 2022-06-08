package ProgrammingFundamentals.Methods.Methods_Lab;

import java.util.Scanner;

public class P09_GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        switch (input) {

            case "int":
                int firstNum = Integer.parseInt(scanner.nextLine());
                int secondNum = Integer.parseInt(scanner.nextLine());
                System.out.println(getMax(firstNum, secondNum));
                break;
            case "char":
                char firstChar = scanner.nextLine().charAt(0);
                char secondChar = scanner.nextLine().charAt(0);
                System.out.println(getMax(firstChar, secondChar));
                break;
            case "string":
                String firstText = scanner.nextLine();
                String secondText = scanner.nextLine();
                System.out.println(getMax(firstText, secondText));
                break;
        }

    }

    public static int getMax(int a, int b) {
        int getMax = 0;
        if (a > b) {
            getMax = a;
        } else {
            getMax = b;
        }
        return getMax;
    }

    public static char getMax(char a, char b) {
        char maxChar = ' ';
        if (a > b) {
            maxChar = a;
        } else {
            maxChar = b;
        }
        return maxChar;
    }

    public static String getMax(String a, String b) {

        String maxText = "";

        if (a.compareTo(b) > 1) {
            maxText = a;
        } else {
            maxText = b;
        }
        return maxText;
    }
}
