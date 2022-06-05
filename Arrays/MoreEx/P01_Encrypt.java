package ProgrammingFundamentals.Arrays.Arrays_Lab.Arrays_MoreEx;

import java.util.Scanner;

public class P01_Encrypt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfNames = Integer.parseInt(scanner.nextLine());


        int counter = 0;
        int[] results = new int[numberOfNames];
       int max = 0;


        while (counter < numberOfNames) {
            String input = scanner.nextLine();
            String[] symbols = input.split("");
            int sum = 0;

            for (int i = 0; i <= symbols.length - 1; i++) {
                String currentSymbol = "";
                currentSymbol = symbols[i];
                char currentChar = currentSymbol.charAt(0);
                int asciiCode = currentChar;

                if (currentChar == 'a' || currentChar == 'A' || currentChar == 'e' || currentChar == 'E' || currentChar == 'u' ||
                        currentChar == 'U' || currentChar == 'o' || currentChar == 'O' || currentChar == 'i' || currentChar == 'I') {
                    sum += asciiCode * symbols.length;
                } else {
                    sum += asciiCode / symbols.length;
                }

            }
            results[counter] = sum;
            counter++;
        }

        for (int i = 0; i <results.length ; i++) {
            for (int j = i+1; j < results.length ; j++) {
                if (results[i]>results[j]){
                    max = results[i];
                    results[i]=results[j];
                    results[j]=max;
                }
            }
        }
        for (int i = 0; i < results.length; i++) {
            System.out.println(results[i]);
        }
    }
}
