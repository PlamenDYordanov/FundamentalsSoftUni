package ProgrammingFundamentals.MapsLambda.Lab;

import java.util.*;
import java.util.stream.Collectors;

public class P03_OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> elementsList = Arrays
                .stream(scanner.nextLine().toLowerCase(Locale.ROOT).split(" "))
                .collect(Collectors.toList());
        Map<String, Integer> oddElements = new LinkedHashMap<>();

        for (int i = 0; i < elementsList.size(); i++) {
            String currentElement = elementsList.get(i);

            if (!oddElements.containsKey(currentElement)){
                oddElements.put(currentElement,1);
            }else {
                oddElements.put(currentElement,oddElements.get(currentElement)+1);
            }

        }
       List<String> odds = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : oddElements.entrySet()) {
            if (entry.getValue()%2==1){
                odds.add(entry.getKey());
            }
        }
        for (int i = 0; i < odds.size(); i++) {
            System.out.print(odds.get(i));
            if (i<odds.size()-1){
                System.out.print(", ");
            }
        }

    }
}
