package ProgrammingFundamentals.ObjectAndClasses.MoreExercises.P04_TeamworkProjects;

public class Team {
    private String team;
    private String user;

    public Team(String team) {
        this.team = team;
    }

    public Team(String team, String user) {
        this.team = team;
        this.user = user;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
