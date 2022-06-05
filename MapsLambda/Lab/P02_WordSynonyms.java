package ProgrammingFundamentals.MapsLambda.Lab;

import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

public class P02_WordSynonyms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPairs = Integer.parseInt(scanner.nextLine());

        Map<String, List<String>> wordsMap = new LinkedHashMap<>();

        for (int i = 0; i < numberOfPairs; i++) {
            String word = scanner.nextLine();
            String synonyms = scanner.nextLine();


            if (!wordsMap.containsKey(word)){

                wordsMap.put(word,new ArrayList<>());
                wordsMap.get(word).add(synonyms);
            }else {
                wordsMap.get(word).add(synonyms);
            }


        }
        for (Map.Entry<String, List<String>> entry : wordsMap.entrySet()) {
            System.out.printf("%s - %s%n",entry.getKey(),String.join(", ", entry.getValue()));
        }

    }
}
