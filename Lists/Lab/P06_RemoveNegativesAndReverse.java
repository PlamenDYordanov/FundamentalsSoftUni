package ProgrammingFundamentals.List_Lab;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P06_RemoveNegativesAndReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> listOfNumbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        listOfNumbers.removeIf(n->n<0);
        Collections.reverse(listOfNumbers);

        if (listOfNumbers.isEmpty()){
            System.out.println("empty");
        }else {
            System.out.println(listOfNumbers.toString().replaceAll("[\\[\\],]",""));
        }
    }
}
