package ProgrammingFundamentals.MapsLambda.Exercises;


import java.util.*;

public class P08_CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, List<String>> companies = new LinkedHashMap<>();
        boolean isExist = false;

        while (!input.equals("End")) {
            String company = input.split(" ->")[0];
            String id = input.split("-> ")[1];

            if (!companies.containsKey(company)) {
                companies.put(company, new ArrayList<>());
                companies.get(company).add(id);
            } else {
                if (companies.get(company).contains(id)) {
                    input = scanner.nextLine();
                    continue;
                } else {
                    companies.get(company).add(id);
                }
            }
            input = scanner.nextLine();

        }
      companies.entrySet()
              .forEach(e -> {
                  System.out.println(String.format("%s",e.getKey()));
                  e.getValue().stream().forEach(p -> System.out.println(String.format("-- %s",p)));
              });

    }

}

