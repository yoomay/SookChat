package com.example.sookchat;

import android.content.Intent;
import android.graphics.Movie;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AgoraFragment extends Fragment {

    private RecyclerView recycler_view;
    private MyRecyclerAdapter myAdapter;
    private List<Data> dataList = new ArrayList<Data>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_agora,container,false);

        //recycler View
        recycler_view=(RecyclerView)view.findViewById(R.id.recycler_view);
        recycler_view.setHasFixedSize(true);
        myAdapter = new MyRecyclerAdapter(getActivity(),dataList);

        RecyclerView.LayoutManager mLayoutManager=new LinearLayoutManager(getActivity());
        recycler_view.setLayoutManager(mLayoutManager);
        recycler_view.setItemAnimator(new DefaultItemAnimator());
        recycler_view.setAdapter(myAdapter);
        getDataList();

        return view;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        //prepareData();
    }

    /**
     public void prepareData(){
     for (int i = 0 ; i<10 ; i++){
     dataList.add(new Data("명신관","설명\n설명\n설명"+i));
     dataList.add(new Data("명신관","설명설명설명"+i));
     dataList.add(new Data("명신관","설명\n설명\n설명"+i));
     dataList.add(new Data("명신관","설명설명설명"+i));

     }
     }**/


    /**@Override
    public void onItemClicked(int position) {
    Intent i = new Intent(getActivity(),CardClickActivity.class);
    startActivity(i);

    }**/

    public void getDataList() {
        RetroFitApiInterface apiInterface = RetroFitApiClient.getClient().create(RetroFitApiInterface.class);
        Call<List<Data>> call = apiInterface.getData();
        call.enqueue(new Callback<List<Data>>() {
            @Override
            public void onResponse(Call<List<Data>> call, Response<List<Data>> response) {
                if (response==null){
                    Toast.makeText(getActivity(), "Somthing Went Wrong!", Toast.LENGTH_SHORT).show();
                }else{
                    for (Data data:response.body()){
                        dataList.add(data);
                    }
                    Log.i("RESPONSE: ", ""+response.toString());
                }
                myAdapter.notifyDataSetChanged();
            }
            @Override
            public void onFailure(Call<List<Data>> call, Throwable t) {
                Toast.makeText(getActivity(), "Unable to fetch json: " + t.getMessage(), Toast.LENGTH_LONG).show();
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }


}