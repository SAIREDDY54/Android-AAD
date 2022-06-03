package com.thkrue.cert.ui;

import android.content.Context;
import android.util.AttributeSet;

import com.thkrue.cert.R;

public class LoginButton extends androidx.appcompat.widget.AppCompatButton {

    public LoginButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        setText("Login");
        setBackground(getResources().getDrawable(R.drawable.bg_login));
    }
}
