package com.sallar.myfastnetworking.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sallar.myfastnetworking.R;
import com.sallar.myfastnetworking.model.POJO;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<POJO> mDataList;
    Context ctx;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvTitle, tvDesc;


        public MyViewHolder(View view) {
            super(view);
            tvTitle =  view.findViewById(R.id.rowTitle);
            tvDesc = view.findViewById(R.id.rowDesc);
        }
    }


    public MyAdapter(Context ctx , List<POJO> dataList) {

        mDataList = dataList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.tvTitle.setText(mDataList.get(position).getTitle());
        holder.tvDesc.setText(mDataList.get(position).getBody());


      /*  holder.tvTitle.setText(pojo.getTitle());
        holder.tvDesc.setText(pojo.getBody());*/

    }



    @Override
    public int getItemCount() {

        return mDataList.size();
    }
}
