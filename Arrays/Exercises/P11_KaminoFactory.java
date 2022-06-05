package ProgrammingFundamentals.Arrays.Arrays_Lab.Arrays_exercises;

import java.util.Scanner;

public class P11_KaminoFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine();
        int counter = 0;

        while (!input.equals("Clone them!")){

            counter ++;

            String noChars = input.replaceAll("!+","");
            String[] noZeros = noChars.split("0");

            for (int i = 0; i < length; i++) {

            }

            input = scanner.nextLine();
        }
    }
}
