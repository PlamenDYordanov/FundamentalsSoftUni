package ProgrammingFundamentals.DataTypesVaribles_Ex;

import java.util.Scanner;

public class P03_Elevator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());
        int capacity = Integer.parseInt(scanner.nextLine());

        double courses = Math.ceil(people*1.0/capacity);
        System.out.printf("%.0f",courses);
    }
}
