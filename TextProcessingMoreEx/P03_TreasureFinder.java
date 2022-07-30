package ProgrammingFundamentals.TextProcessingMoreEx;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03_TreasureFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> arrKey = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("find")) {
            int index = 0;
            StringBuilder decryptText = new StringBuilder();
            for (int i = 0; i < input.length(); i++) {
                char currSymbol = input.charAt(i);
                char toAppend = (char) ((char) currSymbol - arrKey.get(index));
                decryptText.append(toAppend);
                index++;

                if (index == arrKey.size()) {
                    index = 0;
                }
            }
            int firstIndexT = decryptText.indexOf("&");
            int lastIndexT = decryptText.lastIndexOf("&");
            String treasure = decryptText.substring(firstIndexT + 1, lastIndexT);

            int firstIndexC = decryptText.indexOf("<");
            int lastIndexC = decryptText.indexOf(">");
            String coordinates = decryptText.substring(firstIndexC + 1, lastIndexC);

            System.out.printf("Found %s at %s%n",treasure, coordinates);
            input = scanner.nextLine();
        }
    }
}
