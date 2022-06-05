package ProgrammingFundamentals.Arrays.Arrays_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P03_SumEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       int[] arrNum = Arrays
               .stream(scanner.nextLine().split(" "))
               .mapToInt(e -> Integer.parseInt(e))
               .toArray();
       int sum =0;
        for (int i = 0; i < arrNum.length; i++) {
            if (arrNum[i]%2==0){
                sum+=arrNum[i];
            }
        }
        System.out.println(sum);

    }
}
