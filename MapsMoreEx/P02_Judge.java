package ProgrammingFundamentals.MapsMoreEx;

import java.util.*;

public class P02_Judge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, List<String>> mapOfNames = new LinkedHashMap<>();
        Map<String, Integer> mapOfPoints = new LinkedHashMap<>();
        Map<String, List<Integer>> mapCoursesPoints = new LinkedHashMap<>();
        Map<String, List<Integer>> mapTotalPoints = new LinkedHashMap<>();


        while (!input.equals("no more time")) {

            String[] inputLine = input.split(" -> ");
            String name = inputLine[0];
            String contest = inputLine[1];
            int points = Integer.parseInt(inputLine[2]);

            if (!mapOfNames.containsKey(contest)) {
                mapCoursesPoints.put(contest, new ArrayList<>());
                mapCoursesPoints.get(contest).add(points);
                if (mapOfPoints.containsKey(name)) {
                    mapOfNames.put(contest, new ArrayList<>());

                    mapOfNames.get(contest).add(name);
                    int currentPoints = mapOfPoints.get(name);
                    if (currentPoints < points) {
                        mapOfPoints.put(name, points);
                    }

                    mapTotalPoints.get(name).add(points);
                } else {
                    mapOfNames.put(contest, new ArrayList<>());
                    mapOfNames.get(contest).add(name);

                    mapOfPoints.put(name, points);

                    mapTotalPoints.put(name, new ArrayList<>());
                    mapTotalPoints.get(name).add(points);
                }
            } else {

                if (mapOfNames.get(contest).contains(name)) {
                    int currentPoints = mapOfPoints.get(name);
                    if (currentPoints < points) {
                        mapOfPoints.put(name, points);
                        int lastIndex = mapTotalPoints.get(name).size();
                        mapTotalPoints.get(name).set(lastIndex - 1, points);
                    } else {
                        mapTotalPoints.get(name).add(points);
                        mapCoursesPoints.get(contest).add(points);
                    }
                } else {
                    mapOfNames.get(contest).add(name);
                    mapOfPoints.put(name, points);
                    if (!mapTotalPoints.containsKey(name)) {
                        mapTotalPoints.put(name, new ArrayList<>());
                        mapTotalPoints.get(name).add(points);
                    } else {
                        mapTotalPoints.get(name).add(points);
                    }
                }
            }


            input = scanner.nextLine();


        }
        Map<String, Integer> reverseOrder = new LinkedHashMap<>();
        mapOfPoints.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(x -> reverseOrder.put(x.getKey(), x.getValue()));


        for (Map.Entry<String, List<String>> entry : mapOfNames.entrySet()) {
            String nameOfStudent = "";
            System.out.printf("%s: %d participants%n", entry.getKey(), entry.getValue().size());
            int index = 1;
            String currentNames = String.valueOf(entry.getValue());
            String[] names = currentNames.replaceAll("[\\[\\]]", "").split(", ");


            for (Map.Entry<String, List<Integer>> entry1 : mapCoursesPoints.entrySet()) {
                if (!entry.getKey().equals(entry1.getKey())) {
                    continue;
                }
                boolean isFinish = false;
                entry1.getValue().sort(Collections.reverseOrder());
                for (int i = 0; i < entry1.getValue().size(); i++) {

                    int currentPoint = entry1.getValue().get(i);
                    for (Map.Entry<String, List<Integer>> entry2 : mapTotalPoints.entrySet()) {
                        boolean isFindStudent = false;
                        entry2.getValue().sort(Collections.reverseOrder());
                        for (int j = 0; j < entry2.getValue().size(); j++) {
                            if (currentPoint == entry2.getValue().get(j)) {
                                nameOfStudent = entry2.getKey();
                                entry2.getValue().remove(j);
                                isFindStudent = true;
                                break;
                            }
                        }
                        if (isFindStudent) {
                            break;
                        }
                    }


                    System.out.printf("%d. %s <::> %d%n", index, nameOfStudent, currentPoint);
                    index++;
                    if (i == entry1.getValue().size() - 1) {
                        isFinish = true;
                    }

                }
                if (isFinish) {
                    break;
                }
            }
        }
    }
}
