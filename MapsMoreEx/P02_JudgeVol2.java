package ProgrammingFundamentals.MapsMoreEx;

import java.util.*;
import java.util.stream.Collectors;

public class P02_JudgeVol2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Map<String, Integer>> contests = new LinkedHashMap<>();

        String input;
        while (!"no more time".equals(input = scan.nextLine())) {
            String[] tokens = input.split(" -> ");
            String userName = tokens[0];
            String course = tokens[1];
            int userPoints = Integer.parseInt(tokens[2]);

            contests.putIfAbsent(course, new HashMap<>());
            contests.get(course)
                    .compute(userName, (user, oldPoints) ->
                            (oldPoints == null || oldPoints < userPoints) ? userPoints : oldPoints);
        }

        Comparator<Map.Entry<String, Integer>> participantsComparator = Map.Entry.<String, Integer>
                        comparingByValue(Comparator.reverseOrder())
                .thenComparing(Map.Entry.comparingByKey());

        contests.forEach((contest, participants) -> {
            System.out.printf("%s: %d participants\n", contest, participants.size());
            final int[] count = {0};
            participants.entrySet()
                    .stream()
                    .sorted(participantsComparator)
                    .forEach(entry -> {
                        count[0] += 1;
                        System.out.printf("%d. %s <::> %d%n", count[0], entry.getKey(), entry.getValue());
                    });
        });

        System.out.println("Individual standings:");
        final int[] count = {0};
        contests.values()
                .stream()
                .flatMap(m -> m.entrySet().stream())
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.summingInt(Map.Entry::getValue)))
                .entrySet()
                .stream()
                .sorted(participantsComparator)
                .forEach(entry -> {
                    count[0] += 1;
                    System.out.printf("%d. %s -> %d%n", count[0], entry.getKey(), entry.getValue());
                });
    }
}

