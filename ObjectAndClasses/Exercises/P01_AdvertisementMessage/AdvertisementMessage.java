package ProgrammingFundamentals.ObjectAndClasses.Exercises.P01_AdvertisementMessage;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class AdvertisementMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfMessage = Integer.parseInt(scanner.nextLine());

        Random randomGenerator = new Random();
        for (int i = 1; i <= numberOfMessage; i++) {


            String[] phrasesInput = {"Excellent product.", "Such a great product.", "I always use that product.", "Best product of its category.", "Exceptional product.", "I can’t live without this product."};
            int x = randomGenerator.nextInt(phrasesInput.length);

            String[] eventsInput = {"Now I feel good.", "I have succeeded with this product.", "Makes miracles. I am happy of the results!", "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied.", "I feel great!"};
            int y = randomGenerator.nextInt(eventsInput.length);
            String[] authors = {"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};
            int z = randomGenerator.nextInt(authors.length);
            String[] cities = {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};
            int p = randomGenerator.nextInt(cities.length);


            System.out.println(String.format("%s %s %s - %s", phrasesInput[x], eventsInput[y], authors[z], cities[p]));


        }
    }
}
