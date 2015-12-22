package ryanddawkins.com.cornhole.ui.rules;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.Arrays;

import butterknife.Bind;
import butterknife.ButterKnife;
import ryanddawkins.com.cornhole.R;
import ryanddawkins.com.cornhole.base.BaseActivity;

/**
 * Created by ryan on 12/22/15.
 */
public class RulesActivity extends BaseActivity {

    @Nullable
    @Bind(R.id.rv)
    protected RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.setContentView(R.layout.layout_rules);
        ButterKnife.bind(this);

        this.recyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        this.recyclerView.setLayoutManager(llm);

        String[] rules = this.getResources().getStringArray(R.array.rules);

        RVAdapter rvAdapter = new RVAdapter(Arrays.asList(rules));
        this.recyclerView.setAdapter(rvAdapter);
    }
}
