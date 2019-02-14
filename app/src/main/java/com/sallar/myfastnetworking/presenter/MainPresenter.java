package com.sallar.myfastnetworking.presenter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.sallar.myfastnetworking.MVP_Main;
import com.sallar.myfastnetworking.model.MainModel;
import com.sallar.myfastnetworking.model.POJO;
import com.sallar.myfastnetworking.view.MyListAdapter;

import java.lang.ref.WeakReference;
import java.util.List;

import static com.sallar.myfastnetworking.model.MainModel.TAG;

public class MainPresenter implements MVP_Main.ProvidedPresenterOps , MVP_Main.RequiredPresenterOps {

    private WeakReference <MVP_Main.RequiredViewOps> mView;
    // Model reference
    private MVP_Main.ProvidedModelOps mModel;

    //MainModel mainModel = new  MainModel(this);



    public MainPresenter(MVP_Main.RequiredViewOps view) {
        mView = new WeakReference<>(view);


    }

    public void setModel(MVP_Main.ProvidedModelOps model) {
        mModel = model;

       boolean b = mModel.loadData();

        Log.d(TAG, "Data Loaded: "+ b);
    }

    public ArrayAdapter setAdapter(List<POJO> pojo){
       return new MyListAdapter(pojo, getAppContext());
    }

    private MVP_Main.RequiredViewOps getView() throws NullPointerException{
        if ( mView != null )
            return mView.get();
        else
            throw new NullPointerException("View is unavailable");
    }

    @Override
    public void onDestroy(boolean isChangingConfiguration) {
        // View show be null every time onDestroy is called
        mView = null;
        // Inform Model about the event
        mModel.onDestroy(isChangingConfiguration);
        // Activity destroyed
        if ( !isChangingConfiguration ) {
            // Nulls Model when the Activity destruction is permanent
            mModel = null;
        }

    }



    @Override
    public void setView(MVP_Main.RequiredViewOps view) {
        mView = new WeakReference<>(view);
        //mDataList =  mModel.getDataList();
   //     mAdapter = new MyListAdapter(mDataList, mView.getActivityContext());
        getView().setListView(setAdapter(mModel.getDataList()));
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {


        return null;
    }

    @Override
    public Context getAppContext() {
        try {
            return getView().getAppContext();
        }catch (NullPointerException e){
            return null;
        }
    }

    @Override
    public Context getActivityContext() {
        try {
            return getView().getActivityContext();
        }catch (NullPointerException e){
            return null;
        }

    }
}
