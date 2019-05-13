package com.example.sookchat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.net.URL;

public class ChatbotFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_chatbot,container,false);
        Button btn0=(Button) v.findViewById(R.id.btn_main);
        Button btn1=(Button) v.findViewById(R.id.btn_1);
        Button btn2=(Button) v.findViewById(R.id.btn_2);
        Button btn3=(Button) v.findViewById(R.id.btn_3);

        btn0.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                    Intent intent0 = new Intent(getActivity(),WatsonActivity.class);
                    startActivity(intent0);
            }

        });

        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                    Uri uri = Uri.parse("http://www.sookmyung.ac.kr/");
                    Intent intent1 = new Intent(Intent.ACTION_VIEW,uri);
                    startActivity(intent1);
            }

        });

        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Uri uri = Uri.parse("http://lib.sookmyung.ac.kr/");
                Intent intent2 = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent2);
            }

        });

        btn3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Uri uri = Uri.parse("http://snowe.sookmyung.ac.kr/");
                Intent intent3 = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent3);
            }

        });



        return v;



    }


}


