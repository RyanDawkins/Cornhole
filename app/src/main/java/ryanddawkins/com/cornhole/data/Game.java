package ryanddawkins.com.cornhole.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ryan on 12/21/15.
 */
public class Game {

    private int players;
    private int bags;
    private int maxScore;

    private String gameString;

    private int team1Score;
    private int team2Score;

    private List<Round> rounds;

    public Game(NewGame newGame) {
        this.players = newGame.getPlayersNum();
        this.bags = newGame.getBagsNum();
        this.maxScore = newGame.getMaxScore();
        this.gameString = newGame.getGameString();
        this.rounds = new ArrayList<Round>();
    }

    public int getTeam1Score() {
        this.calculateScores();
        return team1Score;
    }

    public int getTeam2Score() {
        this.calculateScores();
        return team2Score;
    }

    private void calculateScores() {
        int team1Score = 0;
        int team2Score = 0;
        for(Round round : this.rounds) {
            team1Score += round.getTeam1Score();
            team2Score += round.getTeam2Score();
        }
        this.team1Score = team1Score;
        this.team2Score = team2Score;
    }

    public List<Round> getRounds() {
        return this.rounds;
    }

    public boolean didTeam1Win() {
        this.calculateScores();
        if(this.team1Score >= this.maxScore) {
            return true;
        } return false;
    }

    public boolean didTeam2Win() {
        this.calculateScores();
        if(this.team2Score >= this.maxScore) {
            return true;
        } return false;
    }

    public void addRound(Round round) {
        this.rounds.add(round);
    }

}
