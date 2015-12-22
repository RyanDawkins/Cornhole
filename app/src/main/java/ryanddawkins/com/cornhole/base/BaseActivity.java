package ryanddawkins.com.cornhole.base;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import ryanddawkins.com.cornhole.R;
import ryanddawkins.com.cornhole.ui.rules.RulesActivity;

/**
 * Created by ryan on 12/21/15.
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected FragmentManager mFragmentManager = null;

    @Nullable
    @Bind(R.id.toolbar)
    protected Toolbar mToolbar;

    @Nullable
    @Bind(R.id.frame_container)
    protected FrameLayout mContainerLayout;

    protected boolean mIsBackNav = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResource());
        ButterKnife.bind(this);

        if(mToolbar != null) {
            setSupportActionBar(mToolbar);
        }

        if(mFragmentManager == null) {
            mFragmentManager = this.getFragmentManager();
        }
    }

    /**
     * Helper method to enable Back navigation for a activity
     * When this method is called the activity will then display
     * a Back arrow that will navigate to the last item on the Stack
     */
    protected void enableBackNav() {
        if(getSupportActionBar() != null) {
            mIsBackNav = true;
            getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    protected void setStatusBarColor(@ColorRes int color) {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.primary_dark));
        }
    }

    /**
     * Helper method to set the Title of the SupportActionBar
     *
     * @param title
     *      The title of this toolbar
     */
    public void setTitle(@NonNull String title) {
        if(getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home && mIsBackNav) {
            super.onBackPressed();
        }
        if(item.getItemId() == R.id.action_rules) {
            Intent intent = new Intent(this, RulesActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @LayoutRes
    protected int getLayoutResource() {
        return R.layout.activity_base;
    }

    /**
     * Helper method to add a Fragment to the Container of this Activity
     * @param fragment
     *      The fragment to be added
     * @param tag
     *      The tag of the fragment to be added
     */
    protected void addFragmentToContainer(Fragment fragment, String tag) {
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_container, fragment, tag).commit();
    }
}