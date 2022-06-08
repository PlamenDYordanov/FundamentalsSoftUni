package ProgrammingFundamentals.Arrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P09_ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arrNum = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String input = scanner.nextLine();
        String indexOne = "";
        String indexTwo = "";
        int currentNum = 0;

        while (!input.equals("end")){

            String[] arrInput = input.split(" ");

            if (arrInput[0].equals("swap")){
                indexOne = arrInput[1];
                indexTwo = arrInput[2];
                int index1 = Integer.parseInt(indexOne);
                int index2 = Integer.parseInt(indexTwo);
                currentNum = arrNum[index1];
                arrNum[index1] = arrNum[index2];
                arrNum[index2] = currentNum;

            }else if (arrInput[0].equals("multiply")){
                indexOne = arrInput[1];
                indexTwo = arrInput[2];
                int index1 =Integer.parseInt(indexOne);
                int index2 =Integer.parseInt(indexTwo);
                currentNum = arrNum[index2];
                arrNum[index1]=currentNum*arrNum[index1];
                arrNum[index2] = currentNum;

            }else if (arrInput[0].equals("decrease")){
                for (int i = 0; i <= arrNum.length - 1 ; i++) {
                    arrNum[i] = arrNum[i]-1;
                }
            }

            input = scanner.nextLine();
        }
        for (int i = 0; i <=arrNum.length -2; i++) {
            System.out.print(arrNum[i]+", ");
        }
        System.out.println(arrNum[arrNum.length-1]);
    }
}
