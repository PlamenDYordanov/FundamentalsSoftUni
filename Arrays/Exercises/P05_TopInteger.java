package ProgrammingFundamentals.Arrays.Arrays_Lab.Arrays_exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P05_TopInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbArr = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();
        String topNumbers = "";


        for (int index = 0; index <= numbArr.length - 1; index++) {
            int currentNum = numbArr[index];
            if (numbArr.length - 1 == index) {
                topNumbers += currentNum;
                break;
            }

            boolean isBigger = false;

            for (int i = index + 1; i <= numbArr.length - 1; i++) {
                if (currentNum > numbArr[i]) {
                    isBigger = true;
                } else {
                    isBigger = false;
                    break;
                }
            }
            if (isBigger) {
                topNumbers += currentNum+" ";
            }
        }
        System.out.println(topNumbers);
    }
}
