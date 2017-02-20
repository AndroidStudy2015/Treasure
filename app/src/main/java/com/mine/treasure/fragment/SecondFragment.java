package com.mine.treasure.fragment;

import com.mine.treasure.R;
import com.mine.treasure.basemvp.BaseMvpFragment;
import com.mine.treasure.presenter.SecondPresenter;

/**
 * Created by a on 2017/2/19.
 */
public class SecondFragment extends BaseMvpFragment<SecondFragment,SecondPresenter> {
    @Override
    public SecondPresenter _initPresenter() {
        return new SecondPresenter();
    }

    @Override
    protected int _getResId() {
        return R.layout.fragment_second;
    }

    @Override
    protected void _initView() {

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
}
