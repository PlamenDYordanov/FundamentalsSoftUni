package ProgrammingFundamentals.TextProcessing.Exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P08_LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();
        String[] arrInput = input.split("\\s+");
        char symbol = ' ';
        char nextSymbol = ' ';
        StringBuilder digits = new StringBuilder();
        double sum = 0;
        double number = 0;
        List<Double> totalSum = new ArrayList<>();

        for (int i = 0; i < arrInput.length; i++) {
            String arrIterate = arrInput[i];

            for (int j = 0; j < arrIterate.length(); j++) {

                symbol = arrIterate.charAt(j);

                if (Character.isUpperCase(symbol)) {
                    int asciiNum = (int) symbol - 64;
                    if (j == 0) {//Divide
                        for (char element : arrIterate.toString().toCharArray()) {
                            if (Character.isDigit(element)) {
                                digits.append(element);
                            }
                        }
                        number = Double.parseDouble(String.valueOf(digits));
                        sum += number / asciiNum;
                    } else if (j == arrIterate.length() - 1) {//subtract
                        sum -= asciiNum;
                    }
                } else if (Character.isLowerCase(symbol)) {
                    int asciiNum = (int) symbol - 96;
                    if (j == 0) {//multiply
                        for (char element : arrIterate.toString().toCharArray()) {
                            if (Character.isDigit(element)) {
                                digits.append(element);
                            }
                        }
                        number = Double.parseDouble(String.valueOf(digits));
                        sum += number * asciiNum;
                    } else if (j == arrIterate.length() - 1) {//add
                        sum += asciiNum;
                    }
                }
            }
            totalSum.add(sum);
            for (int j = digits.length() - 1; j >= 0; j--) {
                digits.deleteCharAt(j);
            }
            sum = 0;
        }
        double result = 0;
        for (double sums : totalSum) {
            result += sums;
        }
        System.out.println(String.format("%.2f",result));

    }
}
