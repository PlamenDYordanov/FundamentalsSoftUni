package ProgrammingFundamentals.ObjectAndClasses.Exercises.P07_OrderByAge;

public class Persons {
    private String name;
    private String ID;
    private int age;

    public String getName() {
        return name;
    }

    public String getID() {
        return ID;
    }

    public int getAge() {
        return age;
    }

    public Persons(String name, String ID, int age){

        this.name = name;
        this.ID = ID;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%s with ID: %s is %d years old.",getName(), getID(), getAge());
    }
}
