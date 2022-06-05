package ProgrammingFundamentals.MapsLambda.Lab;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P01_CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] arrNumbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();

        Map<Double, Integer> counterOfNumbers = new TreeMap<>();

        for (int i = 0; i < arrNumbers.length; i++) {
            double currentNum = arrNumbers[i];

            if (!counterOfNumbers.containsKey(currentNum)){
                counterOfNumbers.put(currentNum,1);

            }else {
                counterOfNumbers.put(currentNum, counterOfNumbers.get(currentNum)+1);
            }
        }
        for (Map.Entry<Double, Integer> entry : counterOfNumbers.entrySet()) {
            System.out.printf("%.0f -> %d%n", entry.getKey(),entry.getValue());
        }

    }
}
