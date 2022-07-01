package ProgrammingFundamentals.ObjectAndClasses.Lab.P01_RandomizeWords;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RandomWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> regularInput = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        Random random = new Random();

        for (int i = 0; i < regularInput.size(); i++) {

            int x = random.nextInt(regularInput.size());
            int y = random.nextInt(regularInput.size());

            String oldWord = regularInput.get(x);
            regularInput.set(x,regularInput.get(y));
            regularInput.set(y,oldWord);

        }
        System.out.println(String.join(System.lineSeparator(),regularInput));

    }
}
