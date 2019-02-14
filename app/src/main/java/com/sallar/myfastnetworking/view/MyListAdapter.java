package com.sallar.myfastnetworking.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.sallar.myfastnetworking.R;
import com.sallar.myfastnetworking.model.POJO;

import java.util.ArrayList;
import java.util.List;

public class MyListAdapter extends ArrayAdapter<POJO> {

    private List<POJO> dataSet;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView tvTitle;
        TextView tvDesc;


    }

    public MyListAdapter(List<POJO> data, Context context) {
        super(context, R.layout.card_view, data);
        this.dataSet = data;
        this.mContext=context;

    }

 /*   @Override
    public void onClick(View v) {

        int position=(Integer) v.getTag();
        Object object= getItem(position);
        DataModel dataModel=(DataModel)object;

        switch (v.getId())
        {
            case R.id.item_info:
                Snackbar.make(v, "Release date " +dataModel.getFeature(), Snackbar.LENGTH_LONG)
                        .setAction("No action", null).show();
                break;
        }
    }*/

   // private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        POJO dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.card_view, parent, false);

            viewHolder.tvTitle = convertView.findViewById(R.id.rowTitle);
            viewHolder.tvDesc = convertView.findViewById(R.id.rowDesc);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

       /* Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        result.startAnimation(animation);
        lastPosition = position;*/

        viewHolder.tvTitle.setText(dataModel.getTitle());
        viewHolder.tvDesc.setText(dataModel.getBody());


        // Return the completed view to render on screen
        return convertView;
    }
}
