package ProgrammingFundamentals.List_Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03_MergingLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstList = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> secondList = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> newArray = new ArrayList<>();

        int minSize = Math.min(firstList.size(), secondList.size());
        int firstRow = 0;
        int secondRow = 0;

        for (int i = 1; i <= minSize * 2; i++) {
            if (i % 2 != 0) {
                newArray.add(firstList.get(firstRow));
                firstRow++;
            } else {
                newArray.add(secondList.get(secondRow));
                secondRow++;
            }
        }
        if (firstList.size() > secondList.size()) {
            for (int i = minSize; i < firstList.size(); i++) {
                newArray.add(firstList.get(i));
            }
        } else {
            for (int i = minSize; i < secondList.size(); i++) {
                newArray.add(secondList.get(i));
            }
        }
        printingNumber(newArray);
    }

    public static void printingNumber(List<Integer> array) {

        for (int numbers : array) {
            System.out.print(numbers + " ");

        }
    }
}
