package com.example.sookchat;

/**
 * Created by VMac on 17/11/16.
 */

import android.text.SpannableString;

import java.io.Serializable;

public class Message implements Serializable {
  String id, message;
  SpannableString messageS;
  String options;

  public Message() {
  }

  public Message(String id, String message, String createdAt) {
    this.id = id;
    this.message = message;
    this.options = options;


  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getOptions(){return options;}

  public void setOptions(String options){this.options = options;}

  /*public void setMessage1(SpannableString messageS){
    this.messageS = messageS;
  }*/


}

