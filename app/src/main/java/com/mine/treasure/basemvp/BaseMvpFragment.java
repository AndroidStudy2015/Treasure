package com.mine.treasure.basemvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.mine.treasure.R;

import butterknife.ButterKnife;


/**
 * BaseMvpActivity主要是为了抽取出MvpActivity所共有的操作
 * 例如：
 * 1.onResume时要 调用: presenter.attach((V)this)---绑定
 * 2.onDestroy时要 调用: presenter.dettach()---解绑（防止Activity内存泄露）
 * 3.暴露一个方法初始化：presenter,以便上面绑定、解绑时使用
 * 4.暴露setContentViewResLayoutId()设置布局的方法
 * 5.暴露initView()方法
 * 6.暴露setListener()方法
 *
 * @param <V>
 * @param <P>
 */
public abstract class BaseMvpFragment<V, P extends BasePresenter<V>> extends Fragment {

    public P presenter;
    View rootView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        1.设置布局ID
         rootView = inflater.inflate(_getResId(), container, false);

//      ★2.这里要初始化presenter，否则不能完成View和Presenter之间的绑定
        presenter = _initPresenter();
//        3.开始绑定Presenter
        if (null != presenter) {
            presenter.attach((V) this);
        }

//        4.layout的ID注入（findViewById）
        ButterKnife.bind(this, rootView);

//      ★5.初始化页面的显示内容，必须在presenter.attach((V) this);之后
//      否则这是后在presenter里调用mView都是空，报错
        _initView();
//        6.设置监听事件
        _setListener();

        return rootView;
    }


    @Override
    public void onDestroy() {
        if (null != presenter) {
            presenter.dettach();
        }
        super.onDestroy();
    }

    /**
     * 这里一定要new Presenter（）初始化之
     * 否则不能完成View和Presenter之间的绑定
     *
     * @return
     */
    public abstract P _initPresenter();

    /**
     * 返回布局资源ID
     *
     * @return
     */
    protected abstract int _getResId();

    /**
     * 初始化页面的显示内容，必须在presenter.attach((V) this);之后
     * 否则这是后在presenter里调用mView都是空，报错
     */
    protected abstract void _initView();

    /**
     * 设置监听事件
     */
    protected abstract void _setListener();


    /**
     * 显示进度圈
     */

    public abstract void _showProgressbar();

    /**
     * 隐藏进度圈
     */

    public abstract void _hiddenProgressbar();


}
