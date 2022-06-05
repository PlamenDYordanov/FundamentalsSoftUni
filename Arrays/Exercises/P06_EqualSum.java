package ProgrammingFundamentals.Arrays.Arrays_Lab.Arrays_exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P06_EqualSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arrNum = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

            int rightSum = 0;
            int leftSum = 0;
            boolean isZero = false;

        for (int i = 0; i <=arrNum.length-1 ; i++) {
            int currentNum = arrNum[i];
            for (int right = i; right < arrNum.length-1 ; right++) {
                rightSum+=arrNum[right+1];
            }
            if (i>0){
                for (int left = i-1; left >=0 ; left--) {
                    leftSum+=arrNum[left];
                }
            }
            if (rightSum==leftSum){
                isZero=true;
                System.out.printf("%d",i);
            }
            rightSum=0;
            leftSum=0;
        }
        if (!isZero){
            System.out.println("no");
        }

    }
}
