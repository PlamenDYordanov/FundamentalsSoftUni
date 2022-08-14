package ProgrammingFundamentals.ObjectAndClasses.MoreExercises.P01_CompanyRoster;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
       Map<String, List<Employee>> mapDepartments =new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] inputLine = scanner.nextLine().split("\\s+");
            String name = inputLine[0];
            double salary = Double.parseDouble(inputLine[1]);
            String position = inputLine[2];
            String department = inputLine[3];
            String email = "";
            String age = "";

            if (inputLine.length == 4) {
                email = "n/a";
                age = "-1";
            } else if (inputLine.length == 5) {
                if (inputLine[4].contains("@")) {
                    email = inputLine[4];
                    age = "-1";
                } else {
                    email = "n/a";
                    age = inputLine[4];
                }
            } else {
                email = inputLine[4];
                age = inputLine[5];
            }
            Employee objEmployee = new Employee(name,salary,position,department,email,age);
            mapDepartments.putIfAbsent(department,new ArrayList<>());
            mapDepartments.get(department).add(objEmployee);
        }
        System.out.println();

        mapDepartments.entrySet().stream().sorted((a,b) -> {
            double averageFirst = a.getValue().stream().mapToDouble(Employee::getSalary).average().orElse(Double.NaN);
            double averageSecond = b.getValue().stream().mapToDouble(Employee::getSalary).average().orElse(Double.NaN);
            return Double.compare(averageSecond,averageFirst);
        }).limit(1).forEach(e ->{
            System.out.println(String.format("Highest Average Salary: %s",e.getKey()));
            e.getValue().stream().sorted((a,b) -> Double.compare(b.getSalary(), a.getSalary())).forEach(o ->
                    System.out.println(String.format("%s %.2f %s %s", o.getName(), o.getSalary(),o.getEmail(),o.getAge())));
        });
        System.out.println();




    }
}
