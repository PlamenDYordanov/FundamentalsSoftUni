package ProgrammingFundamentals.List_Lab;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01_SumAdjacentEqualNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> number =
                Arrays.stream(scanner.nextLine().split(" "))
                        .map(Double::parseDouble)
                        .collect(Collectors.toList());



        for (int i = 0; i < number.size()-1 ; i++) {
            if (number.get(i).equals(number.get(i+1))){
                number.set(i,number.get(i)+number.get(i+1));
                number.remove(i+1);
                i=-1;
            }
        }
       String output = joinElementsByDelimiter(number, " ");
        System.out.println(output);
    }
    public static String joinElementsByDelimiter (List<Double> number, String delimiter){
        String output = "";
        for (Double items: number) {
            DecimalFormat df = new DecimalFormat("0.#");
            output += df.format(items)+delimiter;
        }
        return output;
    }
}
