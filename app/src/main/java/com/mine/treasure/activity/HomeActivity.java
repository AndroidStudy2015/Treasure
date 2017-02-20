package com.mine.treasure.activity;

import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mine.treasure.R;
import com.mine.treasure.base.FragmentFactory;
import com.mine.treasure.basemvp.BaseMvpActivity;
import com.mine.treasure.basemvp.BaseMvpFragment;
import com.mine.treasure.presenter.HomePresenter;

import butterknife.BindView;
import butterknife.OnClick;

public class HomeActivity extends BaseMvpActivity<HomeActivity, HomePresenter> {


    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.tv_first)
    TextView mTvFirst;
    @BindView(R.id.ll_first)
    LinearLayout mLlFirst;
    @BindView(R.id.tv_second)
    TextView mTvSecond;
    @BindView(R.id.ll_second)
    LinearLayout mLlSecond;
    @BindView(R.id.tv_third)
    TextView mTvThird;
    @BindView(R.id.ll_third)
    LinearLayout mLlThird;



    private BaseMvpFragment mFragment0;
    private BaseMvpFragment mFragment1;
    private BaseMvpFragment mFragment2;
    private FragmentManager mManager;
    private FragmentTransaction mTransaction;

    @Override
    public HomePresenter _initPresenter() {
        return new HomePresenter();
    }

    @Override
    protected int _getResId() {
        return R.layout.activity_home;
    }

    @Override
    protected void _initView() {
        setSupportActionBar(mToolbar);
        mManager = getSupportFragmentManager();
        setSelection(0);
    }

    @Override
    protected void _setListener() {

    }

    @Override
    public void _showProgressbar() {
    }

    @Override
    public void _hiddenProgressbar() {
    }

    /**
     * 清除掉所有的选中状态。
     */
    private void clearSelectionState() {
        mTvFirst.setTextColor(Color.parseColor("#000000"));
        mTvSecond.setTextColor(Color.parseColor("#000000"));
        mTvThird.setTextColor(Color.parseColor("#000000"));

        mLlFirst.setBackgroundColor(Color.WHITE);
        mLlSecond.setBackgroundColor(Color.WHITE);
        mLlThird.setBackgroundColor(Color.WHITE);
    }

    /**
     * 将所有的Fragment都置为隐藏状态。
     *
     * @param transaction 用于对Fragment执行操作的事务
     */
    private void hideFragments(FragmentTransaction transaction) {
        if (mFragment0 != null) {
            transaction.hide(mFragment0);
        }
        if (mFragment1 != null) {
            transaction.hide(mFragment1);
        }
        if (mFragment2 != null) {
            transaction.hide(mFragment2);
        }

    }

    @OnClick({R.id.ll_first, R.id.ll_second, R.id.ll_third})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_first:
                setSelection(0);
                break;
            case R.id.ll_second:
                setSelection(1);
                break;
            case R.id.ll_third:
                setSelection(2);
                break;
        }
    }

    private void setSelection(int position) {
        mTransaction = mManager.beginTransaction();
        clearSelectionState();
        switch (position) {
            case 0:
                mFragment0 = FragmentFactory.createFragment(position);
                mLlFirst.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                mTvFirst.setTextColor(Color.WHITE);
                showFragment(mFragment0);
                break;

            case 1:
                mFragment1 = FragmentFactory.createFragment(position);
                mLlSecond.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                mTvSecond.setTextColor(Color.WHITE);
                showFragment(mFragment1);
                break;

            case 2:
                mFragment2 = FragmentFactory.createFragment(position);
                mLlThird.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                mTvThird.setTextColor(Color.WHITE);
                showFragment(mFragment2);
                break;
        }

    }

    public void showFragment(BaseMvpFragment fragment) {
//        要想保留fragment的状态，就要add、hide，而不能replace，replace会重新走fragment的生命周期
//        导致之前的fragment销毁了
//        fragment不能重复add，会报错

        if (!fragment.isAdded()) {
            mTransaction.add(R.id.fl, fragment);
        }
        hideFragments(mTransaction);
        mTransaction.show(fragment);
        mTransaction.commit();

    }


}
