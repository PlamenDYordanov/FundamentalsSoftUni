package ProgrammingFundamentals.DataTypesVaribles_Ex;

import java.util.Scanner;

public class P02_SumDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

//        int lengthOFInt = String.valueOf(number).length();//length of integer
//        int sum = 0;
//        for (int i = 1; i <=lengthOFInt ; i++) {
//            int lastSymbol = number%10;
//            sum +=lastSymbol;
//            number =number/10;
//        }
//        System.out.println(sum);
        int sum = 0;
        while (number > 0) {
            int lastSymbol = number % 10;
            sum += lastSymbol;
            number = number / 10;
        }
        System.out.println(sum);
    }
}
