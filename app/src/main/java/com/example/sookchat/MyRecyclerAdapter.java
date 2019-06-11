package com.example.sookchat;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


import static com.example.sookchat.RetroFitApiClient.BASE_URL;
import static com.example.sookchat.RetroFitApiClient.IMAGE_DIR;
import static com.example.sookchat.RetroFitApiClient.IMAGE_DIR;
import static com.example.sookchat.RetroFitApiClient.IMAGE_DIR;
import static com.example.sookchat.RetroFitApiClient.IMAGE_DIR;
import static com.example.sookchat.RetroFitApiClient.IMAGE_DIR;
import static com.example.sookchat.RetroFitApiClient.IMAGE_DIR;
import static com.example.sookchat.RetroFitApiClient.IMAGE_DIR;

import java.util.ArrayList;
import java.util.List;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder> {
    private List<Data> mDataList;
    private Context mContext;

    public MyRecyclerAdapter(Context mContext, List<Data> mData) {
        this.mContext = mContext;
        this.mDataList = mData;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView content;
        ImageView image;

        CardView cv; //for touch listener

        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title_text);
            content = itemView.findViewById(R.id.contents_text);
            image = itemView.findViewById(R.id.agora_image);
            cv=itemView.findViewById(R.id.cv);
        }
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);

        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Data data = mDataList.get(position);
        holder.title.setText(data.getTitle());
        holder.content.setText(data.getContent());
        Glide.with(mContext)
                .load( IMAGE_DIR + data.getFilename() + ".jpg")
                .centerCrop()
                .into(holder.image);



        holder.cv.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(mContext, CardClickActivity.class);
                mContext.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount () {
        return mDataList.size();
    }


}