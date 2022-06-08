package ProgrammingFundamentals.Methods.Methods_Lab;

import java.util.Scanner;

public class P07_RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        int count = Integer.parseInt(scanner.nextLine());

        System.out.println( repeatText(text,count));

    }
    public static String repeatText(String str, int count){
        String newString = "";
        for (int i = 0; i < count; i++) {
            newString+=str;
        }
        return newString;
    }
}
