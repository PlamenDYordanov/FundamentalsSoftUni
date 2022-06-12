package ProgrammingFundamentals.TextProcessing.Exercises;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class P05_MultiplyBigNumberVol2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigInteger firstNum = new BigInteger(scanner.nextLine());
        BigInteger secondNum = new BigInteger(scanner.nextLine());

        BigInteger result = secondNum.multiply(firstNum);
        System.out.println(result);
    }
}
