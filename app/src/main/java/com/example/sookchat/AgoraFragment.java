package com.example.sookchat;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class AgoraFragment extends Fragment {

    private RecyclerView recyclerView;
    private MyRecyclerAdapter mAdapter;
    private ArrayList<Data> dataList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_agora,container,false);

        //recycler View
        recyclerView=(RecyclerView)view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        mAdapter = new MyRecyclerAdapter(getActivity(),dataList);

        RecyclerView.LayoutManager mLayoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        return view;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        prepareData();
    }

    public void prepareData(){
        for (int i = 0 ; i<10 ; i++){
            dataList.add(new Data("명신관","설명\n설명\n설명"+i));
            dataList.add(new Data("명신관","설명설명설명"+i));
            dataList.add(new Data("명신관","설명\n설명\n설명"+i));
            dataList.add(new Data("명신관","설명설명설명"+i));

        }
    }


    /**@Override
    public void onItemClicked(int position) {
        Intent i = new Intent(getActivity(),CardClickActivity.class);
        startActivity(i);

    }**/
}