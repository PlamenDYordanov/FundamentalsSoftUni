package ProgrammingFundamentals.MapsLambda.Exercises;

import java.util.*;

public class P09_ForceBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> sidesMap = new LinkedHashMap<>();


        String input = scanner.nextLine();

        while (!input.equals("Lumpawaroo")) {
            if (input.contains(" -> ")) {

                String user = input.split(" -> ")[0];
                String side = input.split(" -> ")[1];

                boolean isExist = false;
                for (Map.Entry<String, List<String>> entry : sidesMap.entrySet()) {
                    List<String> names = entry.getValue();
                    if (names.contains(user)) {
                        sidesMap.get(entry.getKey()).remove(user);
                        sidesMap.putIfAbsent(side,new ArrayList<>());
                        sidesMap.get(side).add(user);
                        System.out.printf("%s joins the %s side!%n", user, side);
                        isExist = true;
                        break;
                    }
                }
                if (!isExist) {
                    sidesMap.putIfAbsent(side, new ArrayList<>());

                    if (sidesMap.containsKey(side)) {
                        if (!sidesMap.get(side).contains(user)) {
                            sidesMap.get(side).add(user);
                            System.out.printf("%s joins the %s side!%n", user, side);
                        }
                    } else {
                        sidesMap.get(side).add(user);
                        System.out.printf("%s joins the %s side!%n", user, side);
                    }
                }

            } else if (input.contains(" | ")) {

                String side = input.split(" \\| ")[0];
                String user = input.split(" \\| ")[1];

                sidesMap.putIfAbsent(side, new ArrayList<>());
                if (sidesMap.containsKey(side)) {
                    if (!sidesMap.get(side).contains(user)) {
                        sidesMap.get(side).add(user);
                    }
                } else {
                    sidesMap.get(side).add(user);
                }

            }


            input = scanner.nextLine();
        }

        sidesMap.forEach((e, e1) -> {
            if (e1.size() > 0) {
                System.out.printf("Side: %s, Members: %d%n", e, e1.size());
                e1.forEach(p -> System.out.printf("! %s%n", p));
            }

        });

    }
}
