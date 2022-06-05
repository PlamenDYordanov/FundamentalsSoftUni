package ProgrammingFundamentals.MidExamFirst;

import java.util.*;
import java.util.stream.Collectors;

public class P03_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> listOfNumbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        double sum = 0;

        for (int i = 0; i < listOfNumbers.size(); i++) {
            sum += listOfNumbers.get(i);
        }
        double averageValue = sum / listOfNumbers.size();

        List<Integer> topNumbers = new ArrayList<>();
        for (int i = 0; i < listOfNumbers.size(); i++) {
            if (listOfNumbers.get(i) > averageValue) {
                topNumbers.add(listOfNumbers.get(i));
            }
        }
        Collections.sort(topNumbers);
        Collections.reverse(topNumbers);

        if (topNumbers.size() > 5) {
            for (int i = 0; i < 5; i++) {
                System.out.print(topNumbers.get(i) + " ");
            }
        } else if (topNumbers.isEmpty()) {
            System.out.println("No");
        } else {
            for (int elements : topNumbers) {
                System.out.print(elements + " ");
            }
        }
    }
}
