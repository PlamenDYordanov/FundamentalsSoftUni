package ProgrammingFundamentals.List_Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02_GaussTrick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> arrayNumbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int arraySize = arrayNumbers.size();
        int sum = 0;

        for (int i = 0; i < arraySize/2 ; i++) {
            sum = arrayNumbers.get(i)+arrayNumbers.get(arrayNumbers.size()-1);
            arrayNumbers.remove(i);
            arrayNumbers.remove(arrayNumbers.size()-1);
            arrayNumbers.add(0,sum);
            sum  = 0;

        }
        System.out.println(printNumbers(arrayNumbers));
    }
    public static String printNumbers (List<Integer> array){
            String output = "";
        for (int elements: array) {
            output+=elements+" ";
        }
        return output;
    }
}
