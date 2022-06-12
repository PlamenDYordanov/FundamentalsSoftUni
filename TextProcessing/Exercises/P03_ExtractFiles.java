package ProgrammingFundamentals.TextProcessing.Exercises;

import java.util.Scanner;

public class P03_ExtractFiles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] path = input.split("\\\\");

        String lastLocation = path[path.length - 1];
        String[] nameExtension = lastLocation.split("\\.");
        String name = nameExtension[0];
        String extension = nameExtension[1];

        System.out.println("File name: " + name);
        System.out.println("File extension: " + extension);
    }
}
