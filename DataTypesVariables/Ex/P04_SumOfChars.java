package ProgrammingFundamentals.DataTypesVaribles_Ex;

import java.util.Scanner;

public class P04_SumOfChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countNum = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        for (int i = 1; i <=countNum ; i++) {
            char symbol = scanner.nextLine().charAt(0);
            int symbolNum =Integer.parseInt(String.valueOf(symbol));//if I want to sum integers not ascii code.
            sum+=symbolNum;//if sum ascii code
        }
        System.out.printf("The sum equals: %d",sum);
    }
}
