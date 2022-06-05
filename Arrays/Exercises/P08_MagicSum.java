package ProgrammingFundamentals.Arrays.Arrays_Lab.Arrays_exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P08_MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arrayNum = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int magicNumber = Integer.parseInt(scanner.nextLine());

        int sum = 0;
        int digits = 0;
        int[] magicNums = new int[2];

        for (int i = 0; i <= arrayNum.length - 1; i++) {
            int currentNum = arrayNum[i];
            for (int j = i; j < arrayNum.length - 1; j++) {
                if (currentNum + arrayNum[j + 1] == magicNumber) {
                    digits = arrayNum[j + 1];
                    magicNums[0] = currentNum;
                    magicNums[1] = digits;
                    for (int elements : magicNums) {
                        System.out.print(elements + " ");
                    }
                    System.out.println();
                }
            }


        }
    }

}

