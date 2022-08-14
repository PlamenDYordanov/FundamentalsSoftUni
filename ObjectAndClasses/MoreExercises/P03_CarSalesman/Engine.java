package ProgrammingFundamentals.ObjectAndClasses.MoreExercises.P03_CarSalesman;

public class Engine {
    private String modelName;
    private String hp;
    private String displacement;
    private String efficiency;

    public Engine(String modelName, String hp, String displacement, String efficiency) {
        this.modelName = modelName;
        this.hp = hp;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public String getDisplacement() {
        return displacement;
    }

    public void setDisplacement(String displacement) {
        this.displacement = displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }

    @Override
    public String toString() {
        return String.format("%s:%n  Power: %s%n  Displacement: %s%n  Efficiency: %s%n", getModelName(), getHp(), getDisplacement(), getEfficiency());
    }
}
