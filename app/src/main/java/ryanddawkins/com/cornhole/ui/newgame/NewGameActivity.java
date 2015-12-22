package ryanddawkins.com.cornhole.ui.newgame;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.OnClick;
import ryanddawkins.com.cornhole.R;
import ryanddawkins.com.cornhole.base.BaseActivity;
import ryanddawkins.com.cornhole.data.NewGame;
import ryanddawkins.com.cornhole.ui.game.GameActivity;

/**
 * Created by ryan on 12/21/15.
 */
public class NewGameActivity extends BaseActivity {

    private OfflineFragment offlineFragment;
    private OnlineFragment onlineFragment;
    private NewGame newGame;

    @Bind(R.id.startGame)
    protected Button startGameBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.offlineFragment = OfflineFragment.newInstance();
        this.addFragmentToContainer(this.offlineFragment, "offline");

//        this.onlineFragment = OnlineFragment.newInstance();

        this.newGame = offlineFragment.getState();

//        addFragment("OFFLINE", this.offlineFragment);
//        addFragment("ONLINE", this.onlineFragment);
//        initPager();
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_new_game;
    }

    @OnClick(R.id.startGame)
    public void startGame() {

        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra(GameActivity.NEW_GAME, Parcels.wrap(this.newGame));
        startActivity(intent);

    }
}
