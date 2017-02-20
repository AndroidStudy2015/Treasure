package com.mine.treasure.model;

import com.mine.treasure.basemvp.BaseModel;
import com.mine.treasure.bean.MyHistory;
import com.mine.treasure.bean.Person1;
import com.mine.treasure.retrofit.RetrofitService;
import com.mine.treasure.retrofit.base.BaseCallModel;
import com.mine.treasure.utils.UIUtils;

import java.util.HashMap;
import java.util.Map;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;
import retrofit2.Call;

/**
 * Created by a on 2017/2/19.
 */

public class MainModel extends BaseModel {

    public  Call<BaseCallModel<MyHistory>>  testMapPost() {
      /*  @Field("key") String key,
        @Field("v") String v,
        @Field("month") int month,
        @Field("day") int day*/

        Map<String, String> map = new HashMap<>();
        map.put("key", RetrofitService.key);
        map.put("v", "1.0");
        map.put("month", 1 + "");
        map.put("day", 20 + "");
        Call<BaseCallModel<MyHistory>> call = RetrofitService.service.postMapHistory(map);
        return call;
    }














    public void updateData() {

        //更新Person表里面id为6b6c11c537的数据，address内容更新为“北京朝阳”
        final Person1 p2 = new Person1();
        p2.setAddress("北京朝阳");
        p2.update("olFBOOOS", new UpdateListener() {

            @Override
            public void done(BmobException e) {
                if (e == null) {
                    UIUtils.showToastSafe("更新成功:" + p2.getUpdatedAt());
                } else {
                    UIUtils.showToastSafe("更新失败：" + e.getMessage());
                }
            }

        });
    }

    public void deleteData() {

    }


    public void queryData() {
//        获取一行数据
//        查找Person表里面id为6f424c8e55的数据
        BmobQuery<Person1> bmobQuery = new BmobQuery<Person1>();
        bmobQuery.getObject("6f424c8e55", new QueryListener<Person1>() {
            @Override
            public void done(Person1 object, BmobException e) {
                if (e == null) {
                    UIUtils.showToastSafe("查询成功");
                } else {
                    UIUtils.showToastSafe("查询失败：" + e.getMessage());
                }
            }
        });
    }

    public void addData() {

        //添加一行数据
        Person1 p2 = new Person1();
        p2.setName("lucky");
        p2.setAddress("北京海淀");
        p2.setSex("男");
        p2.save(new SaveListener<String>() {
            @Override
            public void done(String objectId, BmobException e) {
                if (e == null) {
                    UIUtils.showToastSafe("添加数据成功，返回objectId为：" + objectId);
                } else {
                    UIUtils.showToastSafe("创建数据失败：" + e.getMessage() + objectId);
                }
            }
        });
    }
}
