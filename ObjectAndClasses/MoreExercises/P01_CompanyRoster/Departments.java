package ProgrammingFundamentals.ObjectAndClasses.MoreExercises.P01_CompanyRoster;

import java.util.List;

public class Departments {

    String name;
    List<Employees> employee;
    double avgSalary;

    Departments(String name, List<Employees> employee) {
        this.name = name;
        this.employee = employee;
        this.avgSalary = employee.stream().mapToDouble(Employees::getSalary).average().getAsDouble();
    }

    public String getName() {
        return name;
    }

    public List<Employees> getEmployee() {
        return employee;
    }

    public double getAvgSalary() {
        return avgSalary;
    }
}
