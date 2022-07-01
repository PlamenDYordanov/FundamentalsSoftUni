package ProgrammingFundamentals.ObjectAndClasses.Lab.P05_Students;

public class Students {
    String firstName;
    String lastName;
    int age;
    String homeTown;

    Students(String firstName, String lastName, int age, String homeTown){
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
