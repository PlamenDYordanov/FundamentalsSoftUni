package ProgrammingFundamentals.ConditionalStatementsLoopsExercises;

import java.util.Scanner;

public class P09_Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int orders = Integer.parseInt(scanner.nextLine());
        double totalSum = 0;
        for (int i = 1; i <=orders ; i++) {
            double pricePerCaps = Double.parseDouble(scanner.nextLine());
            int days = Integer.parseInt(scanner.nextLine());
            int capsCount = Integer.parseInt(scanner.nextLine());
            double sum = (days*capsCount)*pricePerCaps;
            totalSum+=sum;
            System.out.printf("The price for the coffee is: $%.2f%n",sum);
        }
        System.out.printf("Total: $%.2f%n",totalSum);
    }
}
