package com.mine.treasure.presenter;

import android.view.View;

import com.mine.treasure.basemvp.BasePresenter;
import com.mine.treasure.bean.MyHistory;
import com.mine.treasure.fragment.FirstFragment;
import com.mine.treasure.model.FirstModel;
import com.mine.treasure.retrofit.base.BaseCallModel;
import com.mine.treasure.retrofit.base.BaseCallback;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by a on 2017/2/19.
 */
public class FirstPresent extends BasePresenter<FirstFragment>{

    FirstModel  mModel= new FirstModel();

    public void testMapPost() {
        mView.setErrerPage(View.GONE);
        mView._showProgressbar();

        mModel.testMapPost().enqueue(new BaseCallback<MyHistory>() {
            @Override
            public void onSucess(Call<BaseCallModel<MyHistory>> call, Response<BaseCallModel<MyHistory>> response) {
                List<MyHistory> historyList = response.body().result;
                String str = "";
                for (MyHistory mHistory : historyList) {
                    String string = mHistory.getTitle() + "\n" +
                            mHistory.getDes() + "\n" +
                            mHistory.getLunar() + "\n\n";
                    str = str + string;
                }

                mView._hiddenProgressbar();
                mView.setTv(str);
            }

            @Override
            protected void onFail(String message) {
                mView._hiddenProgressbar();
                mView.setErrerPage(View.VISIBLE);
            }
        });
    }

}
