package ProgrammingFundamentals.ConditionalStatementsLoopsLab;

import java.util.Scanner;

public class P09_SumOfOddNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        n = n*2;

        for (int i = 1; i <= n; i++) {
                if (i  % 2 != 0) {
                    sum += i;
                    System.out.println(i);


            }

        }
        System.out.println("Sum: " + sum);
    }
}

