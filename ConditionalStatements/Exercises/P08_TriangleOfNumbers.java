package ProgrammingFundamentals.ConditionalStatementsLoopsExercises;

import java.util.Scanner;

public class P08_TriangleOfNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        for (int rows = 1; rows <=number ; rows++) {
            for (int column = 1; column <=rows ; column++) {
                System.out.print(rows+" ");
            }
            System.out.println();
        }
    }
}
