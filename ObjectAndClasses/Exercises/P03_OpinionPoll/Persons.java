package ProgrammingFundamentals.ObjectAndClasses.Exercises.P03_OpinionPoll;

public class Persons {
    private String name;
    private int age;

    Persons(String name, int age) {

            this.name = name;
            this.age = age;

    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("%s - %d",getName(),getAge());
    }
}
