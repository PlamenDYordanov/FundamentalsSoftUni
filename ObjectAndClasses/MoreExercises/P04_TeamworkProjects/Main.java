package ProgrammingFundamentals.ObjectAndClasses.MoreExercises.P04_TeamworkProjects;

import javax.print.DocFlavor;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Team> teamList = new ArrayList<>();
        List<String> diffTeam = new ArrayList<>();
        List<String> diffNames = new ArrayList<>();
        Map<String,String> mapBuilders = new HashMap<>();
        for (int i = 0; i < n; i++) {
            boolean isExist = false;
            String[] inputLine = scanner.nextLine().split("-");
            String name = inputLine[0];
            String teams = inputLine[1];

            Team team = new Team(teams, name);
            if (i == 0) {
                teamList.add(team);
                diffTeam.add(teams);
                diffNames.add(name);
                mapBuilders.put(teams, name);
                System.out.printf("Team %s has been created by %s!%n", teams, name);
            } else {
                for (Team team1 : teamList) {
                    if (team1.getTeam().equals(teams)) {
                        System.out.printf("Team %s was already created!%n", teams);
                        isExist = true;
                        break;
                    }
                    if (diffNames.contains(name)) {
                        System.out.printf("%s cannot create another team!%n", name);
                        isExist = true;
                        break;
                    }

                }
                if (!isExist) {
                    teamList.add(team);
                    mapBuilders.put(teams, name);
                    diffTeam.add(teams);
                    diffNames.add(name);
                    System.out.printf("Team %s has been created by %s!%n", teams, name);
                }
            }

        }

        String input = scanner.nextLine();
        while (!input.equals("end of assignment")) {
            boolean isJoin = true;
            String name = input.split("->")[0];
            String team = input.split("->")[1];

            Team objTeam = new Team(team, name);
            if (!diffTeam.contains(team)) {
                System.out.printf("Team %s does not exist!%n", team);
            } else {
                for (Team team1 : teamList) {
                    if (team1.getUser().equals(name)) {
                        System.out.printf("Member %s cannot join team %s!%n", name, team);
                        isJoin = false;
                        break;
                    }
                }
                if (isJoin) {
                    teamList.add(objTeam);


                }

            }

            input = scanner.nextLine();
        }


        Map<String, List<String>> map = new HashMap<String, List<String>>();
        Map<String, List<String>> disband = new TreeMap<>();
        Map<String, List<String>> sorted = new HashMap<>();

        for (int i = 0; i < diffTeam.size(); i++) {
            String currentTeam = diffTeam.get(i);
            for (Team team : teamList) {
                if (currentTeam.equals(team.getTeam())) {

                    map.putIfAbsent(currentTeam, new ArrayList<>());
                    map.get(currentTeam).add(team.getUser());
                }
            }

        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            for (int i = 0; i < entry.getValue().size(); i++) {

            }
        }

       /* map.forEach((e, e1) -> {
            map.entrySet().stream().sorted((p1, p2) -> Integer.compare(p2.getValue().size(), p1.getValue().size()))
                    .sorted((n1, n2) -> n2.getKey().compareTo(n1.getKey()))
                    .forEach(element1 -> {
                        if (element1.getValue().size() > 1) {
                            System.out.printf("%s%n- %s%n", element1.getKey(), element1.getValue());
                        }
                    });

        });*/
        Collection<List<String>> listForMap = map.values();

        for (List<String> strings : listForMap) {
            Collections.sort(strings);
        }


        map.entrySet()
                .stream()
                .sorted((p1, p2) -> {
                    int result = Integer.compare(p2.getValue().size(), p1.getValue().size());
                    if (result == 0) {
                        result = p1.getKey().compareTo(p2.getKey());
                    }

                    return result;
                }).forEach(entry -> {
                    if (entry.getValue().size() > 1) {
                        System.out.printf("%s%n", entry.getKey());
                        StringBuilder dash = new StringBuilder();

                        dash.append("-");
                        entry.getValue()
                                .forEach(e -> {
                                    System.out.printf("%s %s%n", dash, e);
                                    if (dash.length() < 2) {
                                        dash.append("-");
                                    }

                                });
                    } else {
                        disband.put(entry.getKey(), entry.getValue());
                    }

                });


        System.out.println("Teams to disband:");
        diffNames.sort(Comparator.reverseOrder());

        for (Map.Entry<String, List<String>> entry : disband.entrySet()) {
            System.out.printf("%s%n", entry.getKey());
        }


    }
}
