package ProgrammingFundamentals.Methods_Ex;

import java.util.Scanner;

public class P07_NxNMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            getRowInMatrix(n);
            System.out.println();

        }
    }

    public static void getRowInMatrix(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(n + " ");
        }

    }
}
