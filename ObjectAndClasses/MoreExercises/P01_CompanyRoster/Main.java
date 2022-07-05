package ProgrammingFundamentals.ObjectAndClasses.MoreExercises.P01_CompanyRoster;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Employees> employeesList = new ArrayList<>();


        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {

            String inputLine = scanner.nextLine();
            String name = inputLine.split(" ")[0];
            double salary = Double.parseDouble(inputLine.split(" ")[1]);
            String position = inputLine.split(" ")[2];
            String department = inputLine.split(" ")[3];

            if (inputLine.split(" ").length == 6) {
                String email = inputLine.split(" ")[4];
                String age = (inputLine.split(" ")[5]);
                Employees departmentsObj = new Employees(name, salary, position, department, email, age);
                employeesList.add(departmentsObj);

            } else if (inputLine.split(" ").length == 4) {

                String email = "n/a";
                String age = "-1";
                Employees departmentsObj = new Employees(name, salary, position, department, email, age);
                employeesList.add(departmentsObj);
            } else {
                boolean hasItEmail = false;
                String emailOrAge = inputLine.split(" ")[4];
                for (char element : emailOrAge.toCharArray()) {
                    if (element == '@') {
                        hasItEmail = true;
                        break;
                    }
                }
                if (hasItEmail) {
                    String email = inputLine.split(" ")[4];
                    String age = "-1";
                    Employees departmentsObj = new Employees(name, salary, position, department, email, age);
                    employeesList.add(departmentsObj);
                } else {
                    String age = inputLine.split(" ")[4];
                    String email = "n/a";
                    Employees departmentsObj = new Employees(name, salary, position, department, email, age);
                    employeesList.add(departmentsObj);
                }

            }

        }
        List<String> departmentsList = employeesList.stream().map(Employees::getDepartment).distinct().collect(Collectors.toList());

        List<Departments> departments = new ArrayList<>();

        for (String department : departmentsList) {

            departments.add(new Departments(department,
                    employeesList.stream().filter(employees -> employees.getDepartment().equals(department)).collect(Collectors.toList())));
        }
        departments.sort(Comparator.comparing(Departments::getAvgSalary).reversed());
        Departments department = departments.get(0);

        department.getEmployee().sort(Comparator.comparing(Employees::getSalary).reversed());
        System.out.printf("Highest Average Salary: %s%n",department.getName());

        for (Employees employees : department.getEmployee()) {
            System.out.printf("%s %.2f %s %s%n", employees.getName(), employees.getSalary(), employees.getEmail(), employees.getAge());
            
        }


    }
}
