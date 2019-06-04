package com.example.sookchat;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import static com.example.sookchat.RetroFitApiClient.IMAGE_DIR;

public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.ViewHolder> {

    private final List<ImageItem> imageList;


    public ViewAdapter(List<ImageItem> imagelist){
        imageList = imagelist;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView memo;
        ImageView viewimage;

        public ViewHolder(View itemView){
            super(itemView);
            memo = itemView.findViewById(R.id.view_memo);
            viewimage = itemView.findViewById(R.id.view_image);
        }
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_card,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ImageItem imageitem = imageList.get(position);
        holder.memo.setText(imageitem.getMemo());
        Glide.with(holder.itemView.getContext())
                .load( IMAGE_DIR+ imageitem.getFilename() + ".jpg")
                .centerCrop()
                .into(holder.viewimage);

    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

}
