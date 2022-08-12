package ProgrammingFundamentals.MapsMoreEx;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class P03_MOBAChallenger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> mapOfPlayers = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("Season end")) {

            if (input.contains(" -> ")) {
                String name = input.split(" -> ")[0];
                String position = input.split(" -> ")[1];
                int points = Integer.parseInt(input.split(" -> ")[2]);

                mapOfPlayers.putIfAbsent(name, new LinkedHashMap<>());
                if (!mapOfPlayers.get(name).containsKey(position)) {
                    mapOfPlayers.get(name).put(position, points);
                } else {
                    int currentPoints = mapOfPlayers.get(name).get(position);
                    if (currentPoints < points) {
                        mapOfPlayers.get(name).put(position, points);
                    }
                }
            } else if (input.contains(" vs ")) {
                String firstPlayer = input.split(" ")[0];
                String secondPlayer = input.split(" ")[2];

                if (mapOfPlayers.containsKey(firstPlayer) && mapOfPlayers.containsKey(secondPlayer)) {
                    Map<String, Integer> firstPlayerPosition = mapOfPlayers.get(firstPlayer);
                    Map<String, Integer> secondPlayerPosition = mapOfPlayers.get(secondPlayer);
                    for (Map.Entry<String, Integer> entry : firstPlayerPosition.entrySet()) {
                        String currentPosition = entry.getKey();
                        int currentPoints = entry.getValue();
                        for (Map.Entry<String, Integer> stringIntegerEntry : secondPlayerPosition.entrySet()) {

                            if (currentPosition.equals(stringIntegerEntry.getKey()) && currentPoints < stringIntegerEntry.getValue()) {
                                mapOfPlayers.remove(firstPlayer);
                                break;
                            } else if (currentPosition.equals(stringIntegerEntry.getKey()) && currentPoints > stringIntegerEntry.getValue()) {
                                mapOfPlayers.remove(secondPlayer);
                                break;
                            }
                        }

                    }

                }


            }


            input = scanner.nextLine();
        }

        mapOfPlayers.entrySet()
                .stream()
                .sorted((p1, p2) -> {
                    int result = Integer.compare(p2.getValue().values().stream().mapToInt(i -> i).sum(),
                            p1.getValue().values().stream().mapToInt(i -> i).sum());
                    if (result == 0) {
                        result = p1.getKey().compareTo(p2.getKey());
                    }
                    return result;
                })
                .forEach(entry -> {
                    System.out.printf("%s: %d skill%n", entry.getKey(), entry.getValue().values().stream().mapToInt(i -> i).sum());
                    entry.getValue()
                            .entrySet()
                            .stream()
                            .sorted((e1, e2) -> {
                                int res = Integer.compare(e2.getValue(), e1.getValue());
                                if (res == 0) {
                                    res = e1.getKey().compareTo(e2.getKey());
                                }
                                return res;
                            }).forEach(e -> {
                                System.out.printf("- %s <::> %d%n", e.getKey(), e.getValue());
                            });
                });
    }
}


