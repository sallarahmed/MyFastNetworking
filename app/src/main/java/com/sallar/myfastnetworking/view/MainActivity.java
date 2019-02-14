package com.sallar.myfastnetworking.view;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.sallar.myfastnetworking.MVP_Main;
import com.sallar.myfastnetworking.R;
import com.sallar.myfastnetworking.model.MainModel;
import com.sallar.myfastnetworking.model.POJO;
import com.sallar.myfastnetworking.presenter.MainPresenter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MVP_Main.RequiredViewOps {

    public static String TAG = "NetworkDebug";
    Context mContext;
    ListView lv;

  //  private List<POJO> mList = new ArrayList<>();
  //  private RecyclerView recyclerView;
  //  private MyAdapter mAdapter;
    private MyListAdapter myListAdapter;
    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AndroidNetworking.initialize(getApplicationContext());
        mContext = this;
       lv = findViewById(R.id.main_lv);
        presenter = new MainPresenter(this);

        MainModel model = new MainModel(presenter);

        presenter.setModel(model);

        presenter.setView(this);

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy(isChangingConfigurations());

    }

    @Override
    public Context getAppContext() {
        return getApplicationContext();
    }

    @Override
    public Context getActivityContext() {
        return this;
    }


    @Override
    public void setListView(ArrayAdapter adapter) {
        lv.setAdapter(adapter);
    }

    @Override
    public void showToast(Toast toast) {
        toast.show();
    }
}
