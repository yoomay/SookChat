package com.example.sookchat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImageViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
        ImageView iv = (ImageView)findViewById(R.id.iv_large);

        Glide.with(this)
                .load(((WatsonActivity)WatsonActivity.mContext).imageSource)
                .into(iv);
    }
}
