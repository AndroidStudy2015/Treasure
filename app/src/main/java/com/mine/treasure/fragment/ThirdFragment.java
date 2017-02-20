package com.mine.treasure.fragment;

import com.mine.treasure.R;
import com.mine.treasure.basemvp.BaseMvpFragment;
import com.mine.treasure.basemvp.BasePresenter;

/**
 * Created by a on 2017/2/19.
 */
public class ThirdFragment extends BaseMvpFragment {
    @Override
    public BasePresenter _initPresenter() {
        return null;
    }

    @Override
    protected int _getResId() {
        return R.layout.fragment_third;
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
