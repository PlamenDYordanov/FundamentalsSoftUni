package ProgrammingFundamentals.MidExamPreparation.Exam05;

import java.util.Scanner;

public class P01_BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfStudents = Integer.parseInt(scanner.nextLine());
        double numberOfLectures = Double.parseDouble(scanner.nextLine());
        double additionalBonus = Double.parseDouble(scanner.nextLine());


        int maxAttendance = 0;
        double maxTotalBonus = 0;
        double totalBonus = 0;

        for (int i = 1; i <= numberOfStudents; i++) {
            int attendance = Integer.parseInt(scanner.nextLine());
            if (attendance==0){
                continue;
            }


            totalBonus = ((attendance * 1.0 / numberOfLectures) * (5.00 + additionalBonus));

            if (totalBonus > maxTotalBonus) {
                maxTotalBonus = totalBonus;

                maxAttendance = attendance;

            }


        }
        System.out.printf("Max Bonus: %.0f.%n", Math.ceil(maxTotalBonus));
        System.out.printf("The student has attended %d lectures.%n", maxAttendance);
    }
}
