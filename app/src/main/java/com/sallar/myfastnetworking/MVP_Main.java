package com.sallar.myfastnetworking;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.sallar.myfastnetworking.model.POJO;

import java.util.List;

public interface MVP_Main {
    /**
     * Required View methods available to Presenter.
     * A passive layer, responsible to show data
     * and receive user interactions
     *      Presenter to View
     */
    interface RequiredViewOps {
        Context getAppContext();
        Context getActivityContext();
        void setListView(ArrayAdapter adapter);
        void showToast(Toast toast);

    }

    /**
     * Operations offered to View to communicate with Presenter.
     * Process user interaction, sends data requests to Model, etc.
     *      View to Presenter
     */
    interface ProvidedPresenterOps {
        void onDestroy(boolean isChangingConfiguration);
        void setView(RequiredViewOps view);
        View getView(int position , View view , ViewGroup viewGroup);

    }

    /**
     * Required Presenter methods available to Model.
     *      Model to Presenter
     */
    interface RequiredPresenterOps {
        Context getAppContext();
        Context getActivityContext();
    }

    /**
     * Operations offered to Model to communicate with Presenter
     * Handles all data business logic.
     *      Presenter to Model
     */
    interface ProvidedModelOps {
        void onDestroy(boolean isChangingConfiguration);
        int insertData(POJO data);
        boolean loadData();
        List<POJO> getDataList();
        POJO getData(int position);
        boolean deleteData(POJO data, int id);

    }
}
