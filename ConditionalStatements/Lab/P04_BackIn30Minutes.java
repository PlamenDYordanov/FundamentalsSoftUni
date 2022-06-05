package ProgrammingFundamentals.ConditionalStatementsLoopsLab;

import java.util.Scanner;

public class P04_BackIn30Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hours = Integer.parseInt(scanner.nextLine());
        int minutes = Integer.parseInt(scanner.nextLine());

        int convertHToMin = hours * 60;
        int totalTime = convertHToMin + minutes + 30;
        int totalHours = totalTime / 60;
        int totalMinutes = totalTime % 60;
        if (totalHours==24){
            totalHours=0;
        }
        System.out.printf("%d:%02d",totalHours,totalMinutes);

    }
}
