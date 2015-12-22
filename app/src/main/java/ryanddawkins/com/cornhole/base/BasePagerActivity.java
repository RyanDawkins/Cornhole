package ryanddawkins.com.cornhole.base;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import butterknife.Bind;
import ryanddawkins.com.cornhole.R;
import ryanddawkins.com.cornhole.ui.FragmentAdapter;

/**
 * Created by ryan on 12/21/15.
 */
public abstract class BasePagerActivity extends BaseActivity {

    @Bind(R.id.tabs)
    protected TabLayout mTabHost;

    @Bind(R.id.viewpager)
    protected ViewPager mPager;

    protected FragmentAdapter mAdapter;

    protected @LayoutRes
    int mLayout = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdapter = new FragmentAdapter(mFragmentManager);
    }

    @Override
    protected int getLayoutResource() {
        if (mLayout == -1) {
            return R.layout.activity_base_pager;
        } else {
            return mLayout;
        }
    }

    protected void addFragment(String title, Fragment fragment) {
        mAdapter.addFragment(fragment, title);
    }

    protected void setPage(int page) {
        mPager.setCurrentItem(page);
    }

    public int getPage() {
        return this.mPager.getCurrentItem();
    }

    protected void initPager() {
        mPager.setAdapter(mAdapter);
        if(mAdapter.getCount() > 0) {
            mPager.setOffscreenPageLimit(mAdapter.getCount());
        }
        mTabHost.setupWithViewPager(mPager);
    }
}

