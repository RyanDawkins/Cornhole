package ryanddawkins.com.cornhole.data;

/**
 * Created by ryan on 12/21/15.
 */
public class Round {

    private int team1Score;
    private int team2Score;

    public Round() {
        this.team1Score = 0;
        this.team2Score = 0;
    }

    public int getTeam1Score() {
        return team1Score;
    }

    public void setTeam1Score(int team1Score) {
        this.team1Score = team1Score;
    }

    public int getTeam2Score() {
        return team2Score;
    }

    public void setTeam2Score(int team2Score) {
        this.team2Score = team2Score;
    }
}
