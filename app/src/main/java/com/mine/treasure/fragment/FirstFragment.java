package com.mine.treasure.fragment;

import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.mine.treasure.R;
import com.mine.treasure.basemvp.BaseMvpFragment;
import com.mine.treasure.presenter.FirstPresent;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by a on 2017/2/19.
 */
public class FirstFragment extends BaseMvpFragment<FirstFragment, FirstPresent> {
    @BindView(R.id.tv_des)
    TextView mTvDes;
    @BindView(R.id.progressBar)
    ProgressBar mProgressBar;
    @BindView(R.id.loading_error)
    FrameLayout mLoadingError;


    @BindView(R.id.page_bt)
    Button mPageBt;

    @Override
    public FirstPresent _initPresenter() {
        return new FirstPresent();
    }

    @Override
    protected int _getResId() {
        return R.layout.fragment_first;
    }

    @Override
    protected void _initView() {

        presenter.testMapPost();
    }

    @Override
    protected void _setListener() {

    }

    @Override
    public void _showProgressbar() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void _hiddenProgressbar() {
        mProgressBar.setVisibility(View.INVISIBLE);

    }

    public void setTv(String str) {
        mTvDes.setText(str);
    }


    public void setErrerPage(int visible) {
        mLoadingError.setVisibility(visible);
    }



    @OnClick(R.id.page_bt)
    public void onClick() {
        presenter.testMapPost();
    }
}
