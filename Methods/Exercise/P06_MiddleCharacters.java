package ProgrammingFundamentals.Methods.Exercise;

import java.util.Scanner;

public class P06_MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        printMiddleCharacter(text);

    }
    public static void printMiddleCharacter (String text){
        String result = "";

        if (text.length()%2!=0){
            char middleCharacter = text.charAt(text.length()/2);
            result += middleCharacter;
            System.out.println(result);
        }else{
            char firstChar = text.charAt(text.length()/2-1);
            char secondChar = text.charAt(text.length()/2);
            result+=firstChar+""+secondChar;
            System.out.println(result);
        }
    }
}
