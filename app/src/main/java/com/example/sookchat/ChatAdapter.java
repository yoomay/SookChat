package com.example.sookchat;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


  private int SELF = 100;
  private int OPTIONS=3;
  private ArrayList<Message> messageArrayList;
  private  Spannable spanText;
  private ForegroundColorSpan fcs;
  private RelativeSizeSpan rss;
  public EditText inputMessage;

  public ChatAdapter(ArrayList<Message> messageArrayList) {
    this.messageArrayList = messageArrayList;
  }

  @Override
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View itemView;

    // view type is to identify where to render the chat message
    // left or right
    if (viewType == SELF) {
      // self message
      itemView = LayoutInflater.from(parent.getContext())
              .inflate(R.layout.chat_item_self, parent, false);
    }
    //Watson Option Message
    else if(viewType==OPTIONS){
      itemView = LayoutInflater.from(parent.getContext())
              .inflate(R.layout.chat_item_watson_option, parent, false);
    }
    else {
      // WatBot message
      itemView = LayoutInflater.from(parent.getContext())
              .inflate(R.layout.chat_item_watson, parent, false);
    }


    return new ViewHolder(itemView);
  }

  @Override
  public int getItemViewType(int position) {
    Message message = messageArrayList.get(position);
    if (message.getId() != null && message.getId().equals("1")) {
      return SELF;
    }
    else if(message.getId()!=null && message.getId().equals("3")){
      return OPTIONS;
    }

    return position;
  }

  @Override
  public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
    Message message = messageArrayList.get(position);
    if (holder.getItemViewType()==OPTIONS){
      final SpannableString ss = new SpannableString(message.getOptions());
      ClickableSpan clickableSpan1=new ClickableSpan(){
        public void onClick(View widget){
          inputMessage.setText(ss);
        }
      };

      ss.setSpan(clickableSpan1,0,ss.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
      ((ViewHolder) holder).message.setText(ss);
    }
    //message.setMessage(message.getMessage());
    else {
      ((ViewHolder) holder).message.setText(message.getMessage());
    }
  }

  @Override
  public int getItemCount() {
    return messageArrayList.size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder {
    TextView message;

    public ViewHolder(View view) {
      super(view);
      message = (TextView) itemView.findViewById(R.id.message);


      String customFont = "NotoSerif-Regular.ttf";
      Typeface typeface = Typeface.createFromAsset(itemView.getContext().getAssets(), customFont);
      message.setTypeface(typeface);


    }
  }


}