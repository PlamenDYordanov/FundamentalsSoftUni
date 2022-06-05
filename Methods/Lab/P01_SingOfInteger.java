package ProgrammingFundamentals.Methods_Lab;

import java.util.Scanner;

public class P01_SingOfInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        printNumbers(n);

    }
    public static void printNumbers(int number){
        if (number>0){
            System.out.printf("The number %d is positive.",number);
        }else if (number<0){
            System.out.printf("The number %d is negative.",number);
        }else {
            System.out.println("The number 0 is zero.");
        }
    }
}
