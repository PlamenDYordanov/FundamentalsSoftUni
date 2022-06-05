package ProgrammingFundamentals.DataTypesVariables_Lab;

import java.util.Scanner;

public class P12_RefactorSpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        int digit = 0;
        boolean isEqual = false;
        for (int i = 1; i <= n; i++) {
            digit = i;
            sum =0;
            while (digit > 0) {
                sum += digit % 10;
                digit = digit / 10;
            }
            if (sum == 5 || sum == 7 || sum == 11){
                isEqual= true;
            }
            if (isEqual){
                System.out.printf("%d -> True%n",i);
            }else {
                System.out.printf("%d -> False%n",i);
            }
            isEqual = false;

        }

    }
}
