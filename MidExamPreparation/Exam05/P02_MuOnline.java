package ProgrammingFundamentals.MidExamPreparation.Exam05;

import java.util.Scanner;

public class P02_MuOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] inputArr = input.split("\\|");
        int startHealth = 100;
        int startBitcoin = 0;

        boolean isSurvived = true;
        int slayedMonster = 0;
        for (int i = 0; i < inputArr.length; i++) {
            String[] currentInput = inputArr[i].split(" ");
            String action = currentInput[0];
            int value = Integer.parseInt(currentInput[1]);
            slayedMonster++;

            if (action.equals("potion")) {
                if (startHealth == 100) {
                    continue;
                } else {
                    int currentHeal = 0;
                    if (startHealth + value > 100) {
                        currentHeal = 100 - startHealth;
                        startHealth = 100;
                        System.out.printf("You healed for %d hp.%n", currentHeal);
                    } else if (startHealth + value <= 100) {
                        startHealth += value;
                        System.out.printf("You healed for %d hp.%n", value);
                    }
                    System.out.printf("Current health: %d hp.%n", startHealth);
                }

            } else if (action.equals("chest")) {
                startBitcoin += value;
                System.out.printf("You found %d bitcoins.%n", value);

            } else {
                if (startHealth - value > 0) {
                    startHealth -= value;
                    System.out.printf("You slayed %s.%n", action);
                } else if (startHealth - value <= 0) {
                    System.out.printf("You died! Killed by %s.%n", action);
                    System.out.printf("Best room: %d%n", slayedMonster);
                    isSurvived = false;
                    break;
                }
            }

        }
        if (isSurvived) {
            System.out.println("You've made it!");
            System.out.printf("Bitcoins: %d%n", startBitcoin);
            System.out.printf("Health: %d%n", startHealth);
        }
    }
}
