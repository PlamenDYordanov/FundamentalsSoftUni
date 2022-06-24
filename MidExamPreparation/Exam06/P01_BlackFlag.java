package ProgrammingFundamentals.MidExamPreparation.Exam06;

import java.util.Scanner;

public class P01_BlackFlag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int daysOfPlunder = Integer.parseInt(scanner.nextLine());
        int dailyPlunder = Integer.parseInt(scanner.nextLine());
        double expectPlunder = Double.parseDouble(scanner.nextLine());

        double totalPlunder = 0;
        for (int i = 1; i <= daysOfPlunder; i++) {
            totalPlunder += dailyPlunder;
            if (i % 3 == 0) {
                totalPlunder += dailyPlunder * 0.50;
            } if (i % 5 == 0) {
                totalPlunder = totalPlunder * 0.70;

            }

        }
        if (totalPlunder >= expectPlunder) {
            System.out.printf("Ahoy! %.2f plunder gained.", totalPlunder);
        } else {
            System.out.printf("Collected only %.2f%% of the plunder.", (totalPlunder / expectPlunder) * 100);
        }
    }
}
