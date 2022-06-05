package ProgrammingFundamentals.ListExercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P07_AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       String input = scanner.nextLine();
       List<String> listOfInput = Arrays.stream(input.split("\\|")).collect(Collectors.toList());

        Collections.reverse(listOfInput);

        System.out.println(listOfInput.toString().replace("[","")
                .replace(",","")
                .replace("]","")
                .replaceAll("\\s+"," ")
                .trim());

    }

}
