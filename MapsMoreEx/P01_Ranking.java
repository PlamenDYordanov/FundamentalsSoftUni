package ProgrammingFundamentals.MapsMoreEx;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class P01_Ranking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\:");
        Map<String, String> mapOfContest = new LinkedHashMap<>();
        Map<String, List<String>> mapOfCandidateContest = new TreeMap<>();
        Map<String, List<Integer>> mapOfCandidateRating = new TreeMap<>();


        while (!input[0].equals("end of contests")) {
            String contest = input[0];
            String password = input[1];

            mapOfContest.put(contest, password);


            input = scanner.nextLine().split("\\:");
        }
        String[] inputLine = scanner.nextLine().split("=>");
        while (!inputLine[0].equals("end of submissions")) {
            String contest = inputLine[0];
            String password = inputLine[1];
            String nameCandidate = inputLine[2];
            int points = Integer.parseInt(inputLine[3]);
            if (mapOfContest.containsKey(contest) && mapOfContest.get(contest).equals(password)) {
                if (!mapOfCandidateContest.containsKey(nameCandidate)) {
                    mapOfCandidateRating.put(nameCandidate, new ArrayList<>());
                    mapOfCandidateRating.get(nameCandidate).add(points);
                    mapOfCandidateContest.put(nameCandidate, new ArrayList<>());
                    mapOfCandidateContest.get(nameCandidate).add(contest);
                } else {
                    if (mapOfCandidateContest.get(nameCandidate).contains(contest)) {

                        int index = mapOfCandidateContest.get(nameCandidate).indexOf(contest);

                        int currentPoints = mapOfCandidateRating.get(nameCandidate).get(index);
                        if (currentPoints < points) {
                            mapOfCandidateRating.get(nameCandidate).set(index, points);
                        }
                    } else {
                        mapOfCandidateRating.get(nameCandidate).add(points);
                        mapOfCandidateContest.get(nameCandidate).add(contest);
                    }
                }
            }


            inputLine = scanner.nextLine().split("=>");
        }
        int minValue = Integer.MIN_VALUE;
        String nameOfTopStudent = "";
        for (Map.Entry<String, List<Integer>> entry : mapOfCandidateRating.entrySet()) {
            int totalSum = entry.getValue().stream().mapToInt(integer -> integer).sum();
            if (totalSum > minValue) {
                minValue = totalSum;
                nameOfTopStudent = entry.getKey();
            }
        }
        System.out.printf("Best candidate is %s with total %d points.%n", nameOfTopStudent, minValue);
        System.out.println("Ranking:");
        for (Map.Entry<String, List<String>> entry : mapOfCandidateContest.entrySet()) {
            Map<String, Integer> mapOfContestRating = new LinkedHashMap<>();
            Map<String, Integer> reverseOrder = new LinkedHashMap<>();

            String currentContest = String.valueOf(entry.getValue());
           String[] currentContestArr = currentContest.replaceAll("[\\[\\]]", "").split(", ");
            for (int i = 0; i < currentContestArr.length; i++) {
                String currContest = currentContestArr[i];
                mapOfContestRating.put(currContest, mapOfCandidateRating.get(entry.getKey()).get(i));

            }
            mapOfContestRating.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .forEachOrdered(x -> reverseOrder.put(x.getKey(), x.getValue()));

            System.out.printf("%s%n",entry.getKey());
            for (Map.Entry<String, Integer> elements : reverseOrder.entrySet()) {
                System.out.printf("#  %s -> %d%n",elements.getKey(), elements.getValue());
            }


        }


    }
}
