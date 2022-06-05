package ProgrammingFundamentals.ListExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P06_CardGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> cardsFirstPlayer = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> cardsSecondPlayer = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        int minValue = Math.min(cardsFirstPlayer.size(), cardsSecondPlayer.size());

        while (minValue > 0) {
                int firstPlayerCard = cardsFirstPlayer.get(0);
                int secondPlayerCard = cardsSecondPlayer.get(0);
                cardsFirstPlayer.remove(0);
                cardsSecondPlayer.remove(0);
                if (firstPlayerCard > secondPlayerCard) {
                    cardsFirstPlayer.add(firstPlayerCard);
                    cardsFirstPlayer.add(secondPlayerCard);
                } else if (secondPlayerCard > firstPlayerCard) {
                    cardsSecondPlayer.add(secondPlayerCard);
                    cardsSecondPlayer.add(firstPlayerCard);
            }
            minValue = Math.min(cardsFirstPlayer.size(), cardsSecondPlayer.size());
        }
        if (cardsFirstPlayer.size()>cardsSecondPlayer.size()){
            int result = sumWiningDeck(cardsFirstPlayer);
            System.out.printf("First player wins! Sum: %d",result);
        }else {
            int result = sumWiningDeck(cardsSecondPlayer);
            System.out.printf("Second player wins! Sum: %d",result);
        }
    }
    public static int sumWiningDeck (List<Integer> listOfCards){
        int sum = 0;
        for (int totalSum:listOfCards) {
            sum+=totalSum;
        }
        return sum;
    }
}
