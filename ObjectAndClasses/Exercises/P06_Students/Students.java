package ProgrammingFundamentals.ObjectAndClasses.Exercises.P06_Students;

public class Students {
    private String firstName;
    private String secondName;
    private double grade;

    @Override
    public String toString() {
        return String.format("%s %s: %.2f", getFirstName(), getSecondName(), getGrade());
    }

    public Students(String firstName, String secondName, double grade) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.grade = grade;

    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public double getGrade() {
        return grade;
    }
}
