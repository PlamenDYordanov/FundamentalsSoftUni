package ProgrammingFundamentals.Arrays.Arrays_Lab;

import java.util.Scanner;

public class P07_CondenseArrayToNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        int[] arrayNum = Arrays
//                .stream(scanner.nextLine().split(" "))
//                .mapToInt(e->Integer.parseInt(e))
//                .toArray();
        String[] Array = scanner.nextLine().split(" ");
        int[] array = new int[Array.length];
        for (int i = 0; i < Array.length; i++) {
             array[i] = Integer.parseInt(Array[i]);
        }

        while (array.length>1){
            int[] condensed = new int[array.length-1];
            for (int i = 0; i < array.length-1; i++) {
                condensed[i] = array[i] + array[i+1];
            }
            array=condensed;
        }
        System.out.println(array[0]);
    }
}
