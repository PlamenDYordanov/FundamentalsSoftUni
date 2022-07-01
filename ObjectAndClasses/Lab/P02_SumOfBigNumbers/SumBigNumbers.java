package ProgrammingFundamentals.ObjectAndClasses.Lab.P02_SumOfBigNumbers;

import java.math.BigInteger;
import java.util.Scanner;

public class SumBigNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger intOne = new BigInteger(scanner.nextLine());
        BigInteger intTwo = new BigInteger(scanner.nextLine());


        BigInteger sum = intOne.add(intTwo);
        System.out.println(sum);
    }
}
