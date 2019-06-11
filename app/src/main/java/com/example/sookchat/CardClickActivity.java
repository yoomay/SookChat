package com.example.sookchat;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;

public class CardClickActivity extends AppCompatActivity {

        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_cardclick);

            // Fragment로 넘길 Image Resource
            ArrayList<Integer> listImage = new ArrayList<>();
            listImage.add(R.drawable.cafeteria_hyu);
            listImage.add(R.drawable.ic_crown);

            ViewPager viewPager = findViewById(R.id.viewPager);
            FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager());
            // ViewPager와  FragmentAdapter 연결
            viewPager.setAdapter(fragmentAdapter);


            // FragmentAdapter에 Fragment 추가, Image 개수만큼 추가
            for (int i = 0; i < listImage.size(); i++) {
                ImageFragment imageFragment = new ImageFragment();
                Bundle bundle = new Bundle();
                bundle.putInt("imgRes", listImage.get(i));
                imageFragment.setArguments(bundle);
                fragmentAdapter.addItem(imageFragment);
            }
            fragmentAdapter.notifyDataSetChanged();
        }

        class FragmentAdapter extends FragmentPagerAdapter {

            // ViewPager에 들어갈 Fragment들을 담을 리스트
            private ArrayList<Fragment> fragments = new ArrayList<>();

            // 필수 생성자
            FragmentAdapter(FragmentManager fm) {
                super(fm);
            }

            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            // List에 Fragment를 담을 함수
            void addItem(Fragment fragment) {
                fragments.add(fragment);
            }
        }
    }