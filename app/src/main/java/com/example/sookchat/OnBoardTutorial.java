package com.example.sookchat;

import android.graphics.Color;
import android.os.Bundle;

import com.hololo.tutorial.library.Step;
import com.hololo.tutorial.library.TutorialActivity;

public class OnBoardTutorial extends TutorialActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addFragment(new Step.Builder().setTitle("숙챗에 오신 것을 환영합니다!")
                .setBackgroundColor(Color.parseColor("#0086ff")) // int background color
                .setDrawable(R.drawable.ic_crown) // int top drawable
                .setSummary("숙챗은 숙명의, 숙명에 의한, 숙명을 위한 어플리케이션입니다. 지식 공유의 장에 오신것을 환영합니다. ")
                .build());

        addFragment(new Step.Builder().setTitle("This is header")
                .setContent("This is content")
                .setBackgroundColor(Color.parseColor("#0086ff")) // int background color
                .setDrawable(R.drawable.ic_crown) // int top drawable
                .setSummary("This is summary")
                .build());
        addFragment(new Step.Builder().setTitle("This is header")
                .setContent("This is content")
                .setBackgroundColor(Color.parseColor("#0086ff")) // int background color
                .setDrawable(R.drawable.ic_crown) // int top drawable
                .setSummary("This is summary")
                .build());
        addFragment(new Step.Builder().setTitle("This is header")
                .setContent("This is content")
                .setBackgroundColor(Color.parseColor("#0086ff")) // int background color
                .setDrawable(R.drawable.ic_crown) // int top drawable
                .setSummary("This is summary")
                .build());
        addFragment(new Step.Builder().setTitle("This is header")
                .setContent("This is content")
                .setBackgroundColor(Color.parseColor("#0086ff")) // int background color
                .setDrawable(R.drawable.ic_crown) // int top drawable
                .setSummary("This is summary")
                .build());
        addFragment(new Step.Builder().setTitle("This is header")
                .setContent("This is content")
                .setBackgroundColor(Color.parseColor("#0086ff")) // int background color
                .setDrawable(R.drawable.ic_crown) // int top drawable
                .setSummary("This is summary")
                .build());


    }


    @Override
    public void currentFragmentPosition(int position) {

    }
}


