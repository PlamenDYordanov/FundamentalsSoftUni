package ProgrammingFundamentals.DataTypesVariables_Lab;

import java.math.BigDecimal;
import java.util.Scanner;

public class P03_ExtraSumOfRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numbers = Integer.parseInt(scanner.nextLine());
        BigDecimal sum = new BigDecimal(0);
        for (int i = 1; i <= numbers; i++) {
            BigDecimal currentNum = new BigDecimal(scanner.nextLine());
            sum = sum.add(currentNum);
        }
        System.out.println(sum);
    }
}
