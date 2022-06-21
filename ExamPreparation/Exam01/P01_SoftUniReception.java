package ProgrammingFundamentals.MidExamFirst;

import java.util.Scanner;

public class P01_SoftUniReception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstStudentsPerHour = Integer.parseInt(scanner.nextLine());
        int secondStudentsPerHour = Integer.parseInt(scanner.nextLine());
        int thirdStudentsPerHour = Integer.parseInt(scanner.nextLine());
        int studentsForService = Integer.parseInt(scanner.nextLine());

        int totalStudentPerHour = firstStudentsPerHour + secondStudentsPerHour + thirdStudentsPerHour;
        int hours = 0;
        while (studentsForService > 0) {
            hours++;
            if (hours % 4 == 0) {
                hours++;
            }
            studentsForService -= totalStudentPerHour;
        }
        System.out.printf("Time needed: %dh.",hours);
    }
}
