package ProgrammingFundamentals.Methods.Methods_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P10_MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Math.abs(Integer.parseInt(scanner.nextLine()));

        String intToString = Integer.toString(number);
        int[] arrayNumbers = Arrays
                .stream(intToString.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(getMultipleOfEvensAndOdds(arrayNumbers));

    }

    public static int getMultipleOfEvensAndOdds(int[] array) {
        int sumOdd = 0;
        int sumEven = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                sumEven += array[i];
            } else if (array[i] % 2 != 0){
                sumOdd += array[i];
            }
        }
        return sumEven*sumOdd;
    }
}
