package ProgrammingFundamentals.RegularExpresion.Exercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P05_NetherRealms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(",");

        String regexHealth = "[^0-9+\\-*\\/\\.]";
        String regexDamage = "[-+]?[0-9]*\\.?[0-9]+";
        String regexDivOrMulty = "[*\\/]";
        Pattern patternHealth = Pattern.compile(regexHealth);
        Pattern patternDamage = Pattern.compile(regexDamage);
        Pattern patternDivOrMult = Pattern.compile(regexDivOrMulty);
        for (int i = 0; i < input.length; i++) {
            int sumOfChars = 0;
            double damage = 0;
            String inputString = input[i].replaceAll(" ","");
            Matcher matcherHealth = patternHealth.matcher(inputString);

            while (matcherHealth.find()){
                String symbols = matcherHealth.group();
                for (int j = 0; j < symbols.length(); j++) {
                    char symbol = symbols.charAt(j);
                    sumOfChars += (int) symbol;
                }
            }
            Matcher matcherDamage = patternDamage.matcher(inputString);
            while (matcherDamage.find()){
                damage += Double.parseDouble(matcherDamage.group());
            }
            Matcher matcherDivOrMult = patternDivOrMult.matcher(inputString);
            while (matcherDivOrMult.find()){
                String divOrMult = matcherDivOrMult.group();
                if (divOrMult.equals("/")){
                    damage /= 2;
                }else if (divOrMult.equals("*")){
                    damage *= 2;
                }

            }
            System.out.printf("%s - %d health, %.2f damage%n", inputString, sumOfChars, damage);

        }
    }
}