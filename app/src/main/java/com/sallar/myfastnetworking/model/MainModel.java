package com.sallar.myfastnetworking.model;

import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.sallar.myfastnetworking.MVP_Main;
import com.sallar.myfastnetworking.view.MyListAdapter;

import java.util.List;

public class MainModel implements MVP_Main.ProvidedModelOps {

    private MVP_Main.RequiredPresenterOps mPresenter;
    String BASE_URL = "https://jsonplaceholder.typicode.com/posts";
    public static String TAG = "NetworkDebug";
    private List<POJO> mPojoList;

    public MainModel(MVP_Main.RequiredPresenterOps requiredPresenterOps) {
        mPresenter = requiredPresenterOps;
    }


    @Override
    public void onDestroy(boolean isChangingConfiguration) {

    }

    @Override
    public int insertData(POJO data) {
        return 0;
    }

    @Override
    public boolean loadData() {

        AndroidNetworking.get(BASE_URL)
                .setTag(mPresenter.getActivityContext())
                .setPriority(Priority.LOW)
                .build()
                .getAsObjectList(POJO.class, new ParsedRequestListener<List<POJO>>() {
                    @Override
                    public void onResponse(List<POJO> users) {
                        // do anything with response
                        mPojoList = users;
                        //    mAdapter.notifyDataSetChanged();
                        Log.d(TAG, "userList size : " + users.size());
                        for (POJO data: users) {
                            Log.d(TAG, "user Id : " + data.getUserId());
                            Log.d(TAG, "Title : " + data.getTitle());
                            Log.d(TAG, "Id : " + data.getId());
                        }
                    }
                    @Override
                    public void onError(ANError anError) {
                        // handle error
                        Log.e(TAG, "onError: ",anError);
                    }
                });

        return mPojoList != null;
    }



    @Override
    public List<POJO> getDataList() {
        return mPojoList;
    }

    @Override
    public POJO getData(int position) {
        return mPojoList.get(position);
    }

    @Override
    public boolean deleteData(POJO data, int id) {
        return false;
    }
}
