package ProgrammingFundamentals.DataTypesVaribles_Ex;

import java.util.Scanner;

public class P05_PrintPartOfASCIITable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int start = Integer.parseInt(scanner.nextLine());
        int finish = Integer.parseInt(scanner.nextLine());

        for (int i = start; i <=finish ; i++) {
            char symbol  = (char) i;
            System.out.printf("%c ",symbol);
        }
    }
}
