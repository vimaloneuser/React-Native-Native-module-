package com.nativedemo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Dummy extends AppCompatActivity {
    public static LinearLayout mylaut;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dummy);
        mylaut = findViewById(R.id.mylayout);
        startActivity(new Intent(this,MainActivity.class));
    }
}
