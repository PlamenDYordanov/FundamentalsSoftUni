package ProgrammingFundamentals.DataTypesVariables_Lab;

import java.util.Scanner;

public class P10_SpecialNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        boolean isEqual = false;

        int sum = 0;
        for (int i = 1; i <= number; i++) {
            int digit = i;
            sum = 0;
            while (digit > 0) {
                int lastSymbol = digit % 10;
                sum+=lastSymbol;
                digit = digit / 10;

            }
            if (sum==5||sum==7||sum==11){
                isEqual =true;
            }
            if (isEqual){
                System.out.printf("%d -> True%n",i);
            }else {
                System.out.printf("%d -> False%n",i);
            }
            isEqual =false;
        }
    }
}
