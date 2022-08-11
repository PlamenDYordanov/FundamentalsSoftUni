package ProgrammingFundamentals.MapsMoreEx;

import java.time.chrono.MinguoDate;
import java.util.*;
import java.util.stream.Collectors;

public class P02_Judge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();


        Map<String, Map<String, Integer>> contest = new LinkedHashMap<>();


        while (!input.equals("no more time")) {

            String course = input.split(" -> ")[1];
            String name = input.split(" -> ")[0];
            int points = Integer.parseInt(input.split(" -> ")[2]);

            contest.putIfAbsent(course, new LinkedHashMap<>());
            if (!contest.get(course).containsKey(name)) {
                contest.get(course).put(name, points);
            } else {
                int currentPoints = contest.get(course).get(name);
                if (currentPoints < points) {
                    contest.get(course).put(name, points);
                }
            }


            input = scanner.nextLine();


        }

        Comparator<Map.Entry<String, Integer>> participantsComparator = Map.Entry.<String, Integer>
                        comparingByValue(Comparator.reverseOrder())
                .thenComparing(Map.Entry.comparingByKey());

        contest.forEach((exam, participants) -> {
            System.out.printf("%s: %d participants%n", exam, participants.size());
            final int[] index = {0};

            participants.entrySet()
                    .stream()
                    .sorted(participantsComparator)
                    .forEach(e -> {
                        index[0] += 1;
                        System.out.printf("%d. %s <::> %d%n", index[0], e.getKey(), e.getValue());
                    });


        });
        System.out.println("Individual standings:");
        final int[] index = {0};
        contest.values()
                .stream()
                .flatMap(m -> m.entrySet().stream())
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.summingInt(Map.Entry::getValue)))
                .entrySet()
                .stream()
                .sorted(participantsComparator)
                .forEach(entry -> {
                    index[0] += 1;
                    System.out.printf("%d. %s -> %d%n", index[0], entry.getKey(), entry.getValue());
                });

    }
}
