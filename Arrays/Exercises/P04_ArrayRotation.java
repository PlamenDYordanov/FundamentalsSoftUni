package ProgrammingFundamentals.Arrays.Arrays_Lab.Arrays_exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P04_ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();
        int count = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < count; i++) {
                int firstElement = arr[0];
            for (int j = 0; j < arr.length-1; j++) {
                arr[j]=arr[j+1];
            }
            arr[arr.length-1]=firstElement;

        }
        for (int element:arr ) {
            System.out.print(element+" ");
        }
    }
}
