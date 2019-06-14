package com.example.sookchat;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CardClickActivity extends AppCompatActivity {

        private List<ImageItem> imageList = new ArrayList<ImageItem>();
        private ViewAdapter adapter;
        Data data;

        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_cardclick);

            Intent intent = getIntent();
            int catid = intent.getIntExtra("catid", 0);

            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.view_recycler);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
            recyclerView.setLayoutManager(layoutManager);



            adapter = new ViewAdapter(imageList);
            recyclerView.setAdapter(adapter);

            PagerSnapHelper snapHelper = new PagerSnapHelper();
            snapHelper.attachToRecyclerView(recyclerView);


            getDataList(catid);


        }

    @Override
    public void onBackPressed(){

        super.onBackPressed();
    }


    public void getDataList(int catid) {
        RetroFitApiInterface apiInterface = RetroFitApiClient.getClient().create(RetroFitApiInterface.class);
        Call<List<ImageItem>> call = apiInterface.getImage(catid);
        call.enqueue(new Callback<List<ImageItem>>() {
            @Override
            public void onResponse(Call<List<ImageItem>> call, Response<List<ImageItem>> response) {
                if (response == null) {
                    Toast.makeText(CardClickActivity.this, "Somthing Went Wrong!", Toast.LENGTH_SHORT).show();
                } else {
                    for (ImageItem imageitem : response.body()) {
                        imageList.add(imageitem);
                    }
                    Log.i("RESPONSE: ", "" + response.toString());

                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<ImageItem>> call, Throwable t) {
                Toast.makeText(CardClickActivity.this, "Unable to fetch json: " + t.getMessage(), Toast.LENGTH_LONG).show();
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }

}