package com.mine.treasure.presenter;

import com.mine.treasure.activity.MainActivity;
import com.mine.treasure.basemvp.BasePresenter;
import com.mine.treasure.bean.MyHistory;
import com.mine.treasure.model.MainModel;
import com.mine.treasure.retrofit.base.BaseCallModel;
import com.mine.treasure.retrofit.base.BaseCallback;
import com.mine.treasure.utils.UIUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by a on 2017/2/19.
 */

public class MainPresenter extends BasePresenter<MainActivity> {

    MainModel mModel = new MainModel();

    public void updateData() {

        mModel.updateData();
    }

    public void deleteData() {

    }


    public void queryData() {
        mModel.queryData();
    }

    public void addData() {
        mModel.addData();
    }

    public void testMapPost() {
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
                mView.setTv(str);
            }

            @Override
            protected void onFail(String message) {
                UIUtils.showToastSafe(message);
            }
        });
    }
}
