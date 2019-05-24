package com.example.sookchat;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MapCardAdapter extends RecyclerView.Adapter<MapCardAdapter.MyViewHolder>  {

    private LayoutInflater inflater;
    private ArrayList<MapCardFragment> imageModelArrayList;

    //Constructor, imageModelArrayList는 MapCardFragment class에서 object의 이미지 배열 리스트 받음
    public MapCardAdapter(Context ctx, ArrayList<MapCardFragment> imageModelArrayList){

        inflater = LayoutInflater.from(ctx);
        this.imageModelArrayList = imageModelArrayList;
    }
    @Override
    public MapCardAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.recycler_map, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    //This is for setting text in textview and image in imageview, row 갯수만큼 컴파이얼러가 이 함수 부름
    @Override
    public void onBindViewHolder(MapCardAdapter.MyViewHolder holder, int position) {

        holder.iv.setImageResource(imageModelArrayList.get(position).getImage_drawable());
        holder.time.setText(imageModelArrayList.get(position).getName());
    }
    @Override
    public int getItemCount() {
        return imageModelArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView time;
        ImageView iv;

        public MyViewHolder(View itemView) {
            super(itemView);

            time = (TextView) itemView.findViewById(R.id.tv);
            iv = (ImageView) itemView.findViewById(R.id.iv);
        }
    }
}
