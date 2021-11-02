package com.nativedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import static com.nativedemo.CalendarModule.currentActivity;
import static com.nativedemo.CalendarModule.reactContext;

public class NativeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_native);
    }

    private void redirectToRNscreen(View view) {
        currentActivity.startActivity(new Intent(this, reactContext.getClass()));
    }
}