package ProgrammingFundamentals.FinalExam;

import java.util.*;

public class P03_Dictionary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] describeWords = input.split(" \\| ");


        Map<String, List<String>> notebook = new LinkedHashMap<>();
        for (int i = 0; i < describeWords.length; i++) {
            String currentWordWithDescription = describeWords[i];
            String word = currentWordWithDescription.split(":")[0];
            String description = currentWordWithDescription.split(":")[1];

            notebook.putIfAbsent(word, new ArrayList<>());
            notebook.get(word).add(description);
        }
        String[] testWord = scanner.nextLine().split(" \\| ");
        String task = scanner.nextLine();
        if (task.equals("Test")) {
            for (int i = 0; i < testWord.length; i++) {
                String currentWord = testWord[i];
                for (Map.Entry<String, List<String>> entry : notebook.entrySet()) {
                    String currentNoteBookWord = entry.getKey();
                    if (currentNoteBookWord.equals(currentWord)) {
                        System.out.println(String.format("%s:",entry.getKey()));
                       List<String> currentDescribe = entry.getValue();
                        for (String element: currentDescribe) {
                            System.out.printf("-%s%n",element);
                        }

                    }
                }
            }
        }else if (task.equals("Hand Over")){
            List<String> words = new ArrayList<>();
            for (Map.Entry<String, List<String>> entry : notebook.entrySet()) {
                words.add(entry.getKey());
            }
            System.out.print(String.join(" ",words));


        }
    }
}

