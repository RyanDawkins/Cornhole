package ryanddawkins.com.cornhole.data;

import org.parceler.Parcel;

/**
 * Created by ryan on 12/21/15.
 */
@Parcel()
public class NewGame {

    int playersNum;

    int bagsNum;

    int roundsNum;

    String gameString;

    public NewGame() {
        this.playersNum = 2;
        this.bagsNum = 3;
        this.roundsNum = 21;
    }

    public int getPlayersNum() {
        return playersNum;
    }

    public void setPlayersNum(int playersNum) {
        this.playersNum = playersNum;
    }

    public int getBagsNum() {
        return bagsNum;
    }

    public void setBagsNum(int bagsNum) {
        this.bagsNum = bagsNum;
    }

    public int getMaxScore() {
        return roundsNum;
    }

    public void setMaxScore(int roundsNum) {
        this.roundsNum = roundsNum;
    }

    public String getGameString() {
        return gameString;
    }

    public void setGameString(String gameString) {
        this.gameString = gameString;
    }

    @Override
    public String toString() {
        return "Bags: "+this.getBagsNum()+"\nPlayers: "+this.getPlayersNum()+"\nRounds: "+this.getMaxScore();
    }

}
