package ProgrammingFundamentals.DataTypesVaribles_Ex;

import java.util.Scanner;

public class P09_SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int startingYield = Integer.parseInt(scanner.nextLine());
        int yieldPenalty = 10;
        int extracting = startingYield;
        int etan = 26;
        int storage = 0;

        int total = 0;
        int counter = 0;
        while (startingYield >= 100) {
            counter++;
            if (counter == 1) {
                storage = extracting - etan;
                total = storage;
                startingYield = startingYield - 10;
            }


            if (counter > 1 && storage >= 26) {
                total = total + startingYield - 26;
                startingYield = startingYield - 10;
                storage = total;
            } else if (counter > 1) {
                total = total + startingYield;
                startingYield = startingYield - 10;
                storage = total;
            }

        }
        if (storage >= 26) {
            total = total - 26;
        }
        System.out.println(counter);
        System.out.println(total);
    }
}
