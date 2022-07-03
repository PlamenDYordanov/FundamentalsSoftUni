package ProgrammingFundamentals.ObjectAndClasses.Lab.P05_Students.P06_StudentsVol2;

public class StudentsVol2 {
    String firstName;
    String lastName;
    int age;
    String homeTown;

    StudentsVol2(String firstName, String lastName, int age, String homeTown){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.homeTown = homeTown;

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getHomeTown() {
        return homeTown;
    }
}
