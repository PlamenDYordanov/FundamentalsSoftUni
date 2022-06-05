package ProgrammingFundamentals.Arrays.Arrays_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P05_EvenAndOddSubtraction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arrNum = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        int oddSum = 0;
        int evenSum =0;
        for (int i = 1; i <=arrNum.length ; i++) {
            if (arrNum[i-1]%2==0){
                evenSum+=arrNum[i-1];
            }else if (arrNum[i-1]%2!=0){
                oddSum+=arrNum[i-1];
            }
        }
        int diff = evenSum-oddSum;
        System.out.println(diff);
    }
}
