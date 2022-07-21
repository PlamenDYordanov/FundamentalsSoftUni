package ProgrammingFundamentals.FinalExam01;

import java.util.*;

public class P03_ThePianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, String> mapOfKey = new LinkedHashMap<>();
        Map<String, String> mapOfComposer = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {

            String initialPiece = scanner.nextLine();
            String piece = initialPiece.split("\\|")[0];
            String composer = initialPiece.split("\\|")[1];
            String key = initialPiece.split("\\|")[2];

            mapOfComposer.put(piece, composer);
            mapOfKey.put(piece, key);

        }
        String inputLine = scanner.nextLine();

        while (!inputLine.equals("Stop")) {
            String command = inputLine.split("\\|")[0];

            switch (command) {
                case "Add": {
                    String piece = inputLine.split("\\|")[1];
                    String composer = inputLine.split("\\|")[2];
                    String key = inputLine.split("\\|")[3];
                    if (!mapOfComposer.containsKey(piece)){
                        mapOfComposer.put(piece,composer);
                        mapOfKey.put(piece,key);
                        System.out.printf("%s by %s in %s added to the collection!%n",piece, composer, key);
                    }else {
                        System.out.printf("%s is already in the collection!%n",piece);
                    }
                }
                break;
                case "Remove": {
                    String piece = inputLine.split("\\|")[1];
                    if (mapOfComposer.containsKey(piece)){
                        mapOfComposer.remove(piece);
                        mapOfKey.remove(piece);
                        System.out.printf("Successfully removed %s!%n",piece);
                    }else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n",piece);
                    }
                }
                break;
                case "ChangeKey":
                    String piece = inputLine.split("\\|")[1];
                    String newKey = inputLine.split("\\|")[2];
                    if (mapOfKey.containsKey(piece)){
                        mapOfKey.put(piece,newKey);
                        System.out.printf("Changed the key of %s to %s!%n",piece,newKey);
                    }else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n",piece);
                    }
                    break;
            }



            inputLine = scanner.nextLine();
        }
        List<String> keys = new ArrayList<>();
        for (Map.Entry<String, String> entry : mapOfKey.entrySet()) {
            keys.add(entry.getValue());
        }

        int index =0;
        for (Map.Entry<String, String> entry : mapOfComposer.entrySet()) {
            System.out.printf("%s -> Composer: %s, Key: %s%n",entry.getKey(), entry.getValue(), keys.get(index));
            index++;
        }
    }
}
