package ProgrammingFundamentals.MapsLambda.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P04_WordFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<String> wordList = Arrays
                .stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());

        wordList = wordList.stream()
                .filter(w -> w.length() % 2 == 0)
                .collect(Collectors.toList());


        System.out.println(String.join(System.lineSeparator(), wordList).trim());
    }
}
