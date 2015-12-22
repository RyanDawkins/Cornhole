package ryanddawkins.com.cornhole.ui.winner;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ryanddawkins.com.cornhole.R;
import ryanddawkins.com.cornhole.base.BaseActivity;
import ryanddawkins.com.cornhole.ui.newgame.NewGameActivity;

/**
 * Created by ryan on 12/22/15.
 */
public class WinnerActivity extends BaseActivity {

    @Nullable
    @Bind(R.id.message)
    TextView messageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.setContentView(R.layout.activity_winner);
        this.setTitle("Winner!");

        ButterKnife.bind(this);

        int team = this.getIntent().getIntExtra("team", 1);
        this.messageTextView.setText("Team "+team+" wins!");

    }

    @Nullable
    @OnClick(R.id.newGame)
    public void newGame() {
        Intent intent = new Intent(this, NewGameActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }

}
