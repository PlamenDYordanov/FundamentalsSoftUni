package ProgrammingFundamentals.Methods_Lab;

import java.text.DecimalFormat;
import java.util.Scanner;

public class P11_MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        String operator = scanner.nextLine();
        int secondNum = Integer.parseInt(scanner.nextLine());

        DecimalFormat df = new DecimalFormat("0.##");

        System.out.println(df.format(calculations(firstNum, operator, secondNum)));
    }

    public static double calculations(int a, String operator, int b) {
        double result = 0;
        switch (operator) {
            case "*":
                result = a * b;
                break;

            case "+":
                result = a + b;
                break;

            case "-":
                result = a - b;
                break;
            case "/":
                result = a*1.0 / b;
                break;
        }
        return result;
    }
}
