package com.mine.treasure.activity;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mine.treasure.R;
import com.mine.treasure.basemvp.BaseMvpActivity;
import com.mine.treasure.presenter.MainPresenter;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseMvpActivity<MainActivity, MainPresenter> {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.add)
    Button mAdd;
    @BindView(R.id.delete)
    Button mDelete;
    @BindView(R.id.query)
    Button mQuery;
    @BindView(R.id.tv)
    TextView mTv;

    @Override
    public MainPresenter _initPresenter() {
        return new MainPresenter();
    }

    @Override
    protected int _getResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void _initView() {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }


    @OnClick({R.id.add, R.id.delete, R.id.query})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add:
                presenter.addData();
                break;
            case R.id.delete:
                presenter.deleteData();
                presenter.updateData();
                presenter. testMapPost();
                break;
            case R.id.query:
                presenter.queryData();
                break;
        }
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

    public void setTv(String str) {
        mTv.setText(str);
    }
}
