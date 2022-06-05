package ProgrammingFundamentals.Methods_Ex;

import java.util.Scanner;

public class P10_TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        printTopInteger(n);
    }

    public static void printTopInteger(int number) {

        int numberDiff = 0;
        boolean hasItOddDig = false;
        boolean isDivisibleBy8 = false;
        int sum = 0;
        for (int i = 1; i <= number; i++) {
            numberDiff = i;
            while (numberDiff > 0) {

                int lastDigit = numberDiff % 10;//lastDigit
                sum += lastDigit;
                if (lastDigit % 2 != 0) {
                    hasItOddDig = true;
                }
                numberDiff = numberDiff / 10;//removeLastDigit
                }
            if (sum%8==0){
                isDivisibleBy8 = true;
            }
            if (isDivisibleBy8&&hasItOddDig){
                System.out.println(i);
            }
            isDivisibleBy8 = false;
            hasItOddDig=false;
            sum = 0;
            }
        }
    }

