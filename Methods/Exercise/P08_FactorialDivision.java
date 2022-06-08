package ProgrammingFundamentals.Methods.Exercise;

import java.util.Scanner;

public class P08_FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());

        double firstFact =  numberFactorial(firstNum);
        double secondFact = numberFactorial(secondNum);
        double result = firstFact/secondFact;
        System.out.printf("%.2f",result);
    }
    public static double numberFactorial (double number){
            double fact = 1;
        for (int i = 1; i <= number ; i++) {
            fact *= i;
        }
        return fact;
    }
}
