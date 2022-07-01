package ProgrammingFundamentals.ObjectAndClasses.Lab.P03_BigFactorial;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class Calculate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int total = 1;
        BigInteger factorial = new BigInteger(String.valueOf(1));


        for (int i = 1; i <= n; i++) {
            total *= i;
            BigInteger multiply = factorial.multiply(BigInteger.valueOf(i));
            factorial.multiply(multiply.multiply(factorial));
        }
    }
}
