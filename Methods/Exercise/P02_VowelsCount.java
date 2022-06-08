package ProgrammingFundamentals.Methods.Exercise;

import java.util.Locale;
import java.util.Scanner;

public class P02_VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine().toLowerCase();
        printVowelCount(text);

    }
    public  static void printVowelCount(String text){
        int counter = 0;
        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            if (currentChar=='a'||currentChar=='e'||currentChar=='u'||currentChar=='i'
            ||currentChar=='o'){
                counter++;
            }
        }
        System.out.println(counter);
    }
}
