package ProgrammingFundamentals.ExamPreparation.Exam03;

import java.util.Scanner;

public class P01_CounterStrike {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int initialEnergy = Integer.parseInt(scanner.nextLine());
        String inputLine = scanner.nextLine();


        int wonBattles = 0;
        boolean isEnoughEnergy = true;
        while (!inputLine.equals("End of battle")) {
            int distanceToEnemy = Integer.parseInt(inputLine);
            if (initialEnergy >= distanceToEnemy) {
                initialEnergy -= distanceToEnemy;
                wonBattles++;
            } else {
                isEnoughEnergy = false;
                break;
            }
            if (wonBattles % 3 == 0) {
                initialEnergy += wonBattles;
            }

            inputLine = scanner.nextLine();
        }
        if (!isEnoughEnergy) {
            System.out.printf("Not enough energy! Game ends with %d won battles and %d energy", wonBattles, initialEnergy);
        }else {
            System.out.printf("Won battles: %d. Energy left: %d",wonBattles,initialEnergy);
        }
    }
}
