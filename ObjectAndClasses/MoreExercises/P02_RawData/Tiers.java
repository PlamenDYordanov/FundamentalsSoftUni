package ProgrammingFundamentals.ObjectAndClasses.MoreExercises.P02_RawData;

public class Tiers {


    private  double pressure;
    private  int age;

    public Tiers(double pressure, int age) {
        this.pressure = pressure;
        this.age = age;
    }


    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
