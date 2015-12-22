package ryanddawkins.com.cornhole.ui.newgame;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import butterknife.Bind;
import info.hoang8f.android.segmented.SegmentedGroup;
import ryanddawkins.com.cornhole.R;
import ryanddawkins.com.cornhole.base.BaseFragment;
import ryanddawkins.com.cornhole.data.NewGame;

/**
 * Created by ryan on 12/21/15.
 */
public class OfflineFragment extends BaseFragment implements GameState {

    @Bind(R.id.players_num)
    protected SegmentedGroup playersNumGroup;

    @Bind(R.id.rounds_num)
    protected SegmentedGroup roundsNumGroup;

    @Bind(R.id.bags_num)
    protected SegmentedGroup bagsNumGroup;

    private NewGame newGame;

    public static OfflineFragment newInstance() {
        Bundle args = new Bundle();
        OfflineFragment fragment = new OfflineFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public OfflineFragment() {
        this.newGame = new NewGame();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = super.onCreateView(inflater, container, savedInstanceState);

        this.playersNumGroup.check(R.id.two);
        this.roundsNumGroup.check(R.id.twentyOne);
        this.bagsNumGroup.check(R.id.three);

        this.playersNumGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId) {
                    case R.id.one:
                        newGame.setPlayersNum(1);
                        break;
                    case R.id.two:
                        newGame.setPlayersNum(2);
                        break;
                    case R.id.three:
                        newGame.setPlayersNum(3);
                        break;
                    case R.id.four:
                        newGame.setPlayersNum(4);
                }

            }
        });

        this.bagsNumGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.one:
                        newGame.setBagsNum(1);
                        break;
                    case R.id.two:
                        newGame.setBagsNum(2);
                        break;
                    case R.id.three:
                        newGame.setBagsNum(3);
                        break;
                    case R.id.four:
                        newGame.setBagsNum(4);
                        break;
                    case R.id.five:
                        newGame.setBagsNum(5);
                }
            }
        });

        this.roundsNumGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId) {
//                    case R.id.seven:
//                        newGame.setMaxScore(7);
//                        break;
                    case R.id.fourteen:
                        newGame.setMaxScore(14);
                        break;
                    case R.id.twentyOne:
                        newGame.setMaxScore(21);
                        break;
                }
            }
        });

        return view;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.offline;
    }

    @Override
    public NewGame getState() {



        return this.newGame;
    }
}
