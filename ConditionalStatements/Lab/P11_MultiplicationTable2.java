package ProgrammingFundamentals.ConditionalStatementsLoopsLab;

import java.util.Scanner;

public class P11_MultiplicationTable2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        int multiplier = Integer.parseInt(scanner.nextLine());

        for (int i = number; i <= number; i++) {
            for (int j = multiplier; j <= 10; j++) {
                System.out.printf("%d X %d = %d%n", i, j, i * j);

            }
        }
        if (multiplier > 10) {
            System.out.printf("%d X %d = %d", number, multiplier, number * multiplier);
        }
    }
}
