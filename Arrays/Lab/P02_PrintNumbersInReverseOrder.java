package ProgrammingFundamentals.Arrays.Arrays_Lab;

import java.util.Scanner;

public class P02_PrintNumbersInReverseOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] arrNum = new int[n];
        for (int i = 0; i < n; i++) {
            int numbers = Integer.parseInt(scanner.nextLine());
            arrNum[i]=numbers;

        }

        for (int i = arrNum.length-1; i >= 0 ; i--) {
            System.out.print(arrNum[i]+" ");
        }

    }
}

