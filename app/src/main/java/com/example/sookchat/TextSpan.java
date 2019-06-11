package com.example.sookchat;

import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class TextSpan extends ClickableSpan {
    @Override
    public void onClick(View widget){
        TextView tv= (TextView)widget;
        Spanned s = (Spanned) tv.getText();

    }
}
