package ProgrammingFundamentals.DataTypesVariables_Lab;

import java.util.Scanner;

public class P06_CharToString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char firstSymbol = scanner.nextLine().charAt(0);
        char secondSymbol = scanner.nextLine().charAt(0);
        char thirdSymbol = scanner.nextLine().charAt(0);


     String result = String.valueOf(""+firstSymbol+secondSymbol+thirdSymbol);//If don't have quotes returns int
        System.out.println(result);


    }
}
