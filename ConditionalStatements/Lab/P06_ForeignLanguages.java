package ProgrammingFundamentals.ConditionalStatementsLoopsLab;

import java.util.Scanner;

public class P06_ForeignLanguages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String countryName = scanner.nextLine();

        switch (countryName){
            case "England":
            case "USA":
                System.out.print("English");
                break;
            case "Spain":
            case"Mexico":
            case "Argentina":
                System.out.print("Spanish");
                break;
            default:
                System.out.print("unknown");
                break;
        }
    }
}
