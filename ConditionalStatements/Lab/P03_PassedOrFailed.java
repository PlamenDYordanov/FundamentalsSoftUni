package ProgrammingFundamentals.ConditionalStatementsLoopsLab;

import java.util.Scanner;

public class P03_PassedOrFailed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double number = Double.parseDouble(scanner.nextLine());

        if (number>=3){
            System.out.println("Passed!");
        }else {
            System.out.println("Failed!");
        }
    }
}
