package ryanddawkins.com.cornhole.ui.game;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ryanddawkins.com.cornhole.R;
import ryanddawkins.com.cornhole.base.BaseActivity;
import ryanddawkins.com.cornhole.data.Game;
import ryanddawkins.com.cornhole.data.NewGame;
import ryanddawkins.com.cornhole.data.Round;
import ryanddawkins.com.cornhole.ui.winner.WinnerActivity;

/**
 * Created by ryan on 12/21/15.
 */
public class GameActivity extends BaseActivity {

    public static String NEW_GAME = "newGame";

    private Game game;
    private Round round;

    @Nullable
    @Bind(R.id.team1)
    protected TextView team1TextView;

    @Nullable
    @Bind(R.id.team2)
    protected TextView team2TextView;

    @Nullable
    @Bind(R.id.chart)
    protected BarChart barChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.setContentView(R.layout.activity_game);

        this.setTitle("Corn Hole Score Keeper");
        this.mToolbar.setTitle("Corn Hole Score Keeper");

        ButterKnife.bind(this);

        NewGame newGame = Parcels.unwrap(this.getIntent().getParcelableExtra(NEW_GAME));

        Log.d("newgame", newGame.toString());

        this.round = new Round();

        this.game = new Game(newGame);
        this.game.addRound(this.round);
        this.updateChart();
    }

    public void updateChart() {
        ArrayList<String> xVals = new ArrayList<String>();
        ArrayList<BarEntry> team1Scores = new ArrayList<BarEntry>();
        ArrayList<BarEntry> team2Scores = new ArrayList<BarEntry>();

        int count = 0;
        for(Round round : this.game.getRounds()) {
            xVals.add(""+count+1);

            team1Scores.add(new BarEntry(round.getTeam1Score(), count));
            team2Scores.add(new BarEntry(round.getTeam2Score(), count));

            count++;
        }

        ArrayList<BarDataSet> barDataSets = new ArrayList<BarDataSet>();
        BarDataSet team1DataSet = new BarDataSet(team1Scores, "Team 1");
        BarDataSet team2DataSet = new BarDataSet(team2Scores, "Team 2");

        team1DataSet.setColor(getResources().getColor(R.color.blue_500));
        team2DataSet.setColor(getResources().getColor(R.color.red_500));

        barDataSets.add(team1DataSet);
        barDataSets.add(team2DataSet);

        BarData data = new BarData(xVals, barDataSets);

        this.barChart.setData(data);
        this.barChart.invalidate();
    }

    public void updateScore() {
        this.team1TextView.setText(""+this.game.getTeam1Score());
        this.team2TextView.setText(""+this.game.getTeam2Score());

        if(this.game.didTeam1Win()) {
            Intent intent = new Intent(this, WinnerActivity.class);
            intent.putExtra("team", 1);
            startActivity(intent);
        }
        if(this.game.didTeam2Win()) {
            Intent intent = new Intent(this, WinnerActivity.class);
            intent.putExtra("team", 2);
            startActivity(intent);
        }

        this.updateChart();
    }

    @Nullable
    @OnClick(R.id.team1add1)
    public void team1Add1() {
        this.round.setTeam1Score(this.round.getTeam1Score() + 1);
        this.updateScore();
    }

    @Nullable
    @OnClick(R.id.team1add3)
    public void team1Add3() {
        this.round.setTeam1Score(this.round.getTeam1Score() + 3);
        this.updateScore();
    }

    @Nullable
    @OnClick(R.id.team1sub1)
    public void team1Sub1() {
        this.round.setTeam1Score(this.round.getTeam1Score() - 1);
        this.updateScore();
    }

    @Nullable
    @OnClick(R.id.team1sub3)
    public void team1Sub3() {
        this.round.setTeam1Score(this.round.getTeam1Score() - 3);
        this.updateScore();
    }

    @Nullable
    @OnClick(R.id.team2add1)
    public void team2Add1() {
        this.round.setTeam2Score(this.round.getTeam2Score() + 1);
        this.updateScore();
    }

    @Nullable
    @OnClick(R.id.team2add3)
    public void team2Add3() {
        this.round.setTeam2Score(this.round.getTeam2Score() + 3);
        this.updateScore();
    }

    @Nullable
    @OnClick(R.id.team2sub1)
    public void team2sub1() {
        this.round.setTeam2Score(this.round.getTeam2Score() - 1);
        this.updateScore();
    }

    @Nullable
    @OnClick(R.id.team2sub3)
    public void team2sub3() {
        this.round.setTeam2Score(this.round.getTeam1Score() - 3);
        this.updateScore();
    }

    @Nullable
    @OnClick(R.id.nextRoundBtn)
    public void nextRoundBtn() {
        this.round = new Round();
        this.game.addRound(round);
    }

}
