package com.nativedemo; // replace com.your-app-name with your app’s name

import com.facebook.react.ReactRootView;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import dev.shreyaspatil.MaterialDialog.AbstractDialog;
import dev.shreyaspatil.MaterialDialog.BottomSheetMaterialDialog;
import dev.shreyaspatil.MaterialDialog.MaterialDialog;
import dev.shreyaspatil.MaterialDialog.interfaces.DialogInterface;
import dev.shreyaspatil.MaterialDialog.model.TextAlignment;

import static androidx.core.content.ContextCompat.startActivity;
import static com.nativedemo.Dummy.mylaut;


public class CalendarModule extends ReactContextBaseJavaModule {
    public static ReactApplicationContext reactContext;
    public static Activity currentActivity;
    LinearLayout myLaoyout;

    CalendarModule(ReactApplicationContext context) {
        super(context);
        reactContext = context;
    }

    // add to CalendarModule.java
    @Override
    public String getName() {
        return "CalendarModule";
    }

    @ReactMethod
    public void createCalendarEvent(String name, String location) {
        Log.d("CalendarModule", "Create event called with name: " + name
                + " and location: " + location);
    }

    @ReactMethod
    public void showSnacBar(String name) {
        ViewGroup view;
        try {
            view = (ViewGroup) getCurrentActivity().getWindow().getDecorView().findViewById(android.R.id.content);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        Snackbar snackbar = Snackbar
                .make(view, "hello " + name, Snackbar.LENGTH_LONG);
        snackbar.show();
    }

    @ReactMethod
    public void showToast(String name) {
        Toast.makeText(reactContext, "hello " + name, Toast.LENGTH_SHORT).show();
    }

    @ReactMethod
    public void deleteFile() {
        currentActivity = getCurrentActivity();
        try {
            MaterialDialog mDialog = new MaterialDialog.Builder(currentActivity)
                    .setAnimation(R.raw.delete_anim)
                    .setTitle("Delete?")
                    .setMessage("Are you sure want to delete this file?")
                    .setCancelable(true)
                    .setPositiveButton("Delete", R.drawable.delete, new MaterialDialog.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int which) {
                            // Delete Operation
                            Toast.makeText(reactContext, "Delete Opration", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setNegativeButton("Cancel", R.drawable.cancel, new MaterialDialog.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int which) {
                            dialogInterface.dismiss();
                            Toast.makeText(reactContext, "Cancel Opration", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .build();

            // Show Dialog
            mDialog.show();
        } catch (Exception e) {

        }
    }

    @ReactMethod
    public void bottomModal() {
        currentActivity = getCurrentActivity();
        try {
            BottomSheetMaterialDialog mDialog = new BottomSheetMaterialDialog.Builder(currentActivity)
                    .setAnimation(R.raw.delete_anim)
                    .setTitle("Delete ?", TextAlignment.END)
                    .setMessage("Are you sure want to delete this file?",TextAlignment.END)
                    .setCancelable(true)
                    .setPositiveButton("Delete", R.drawable.delete, new MaterialDialog.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int which) {
                            // Delete Operation
                            Toast.makeText(reactContext, "Delete Opration", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setNegativeButton("Cancel", R.drawable.cancel, new MaterialDialog.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int which) {
                            dialogInterface.dismiss();
                            Toast.makeText(reactContext, "Cancel Opration", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .build();
            // Show Dialog
            mDialog.show();
        } catch (Exception e) {

        }
    }

    @ReactMethod
    public void message() {
        currentActivity = getCurrentActivity();
        try {
            BottomSheetMaterialDialog mDialog = new BottomSheetMaterialDialog.Builder(currentActivity)
                    .setAnimation(R.raw.delete_anim)
                    .setTitle("Delete?", TextAlignment.END)
                    .setCancelable(true)
                    .setPositiveButton("Delete", R.drawable.delete, new MaterialDialog.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int which) {
                            // Delete Operation
                            Toast.makeText(reactContext, "Delete Opration", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setNegativeButton("Cancel", R.drawable.cancel, new MaterialDialog.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int which) {
                            dialogInterface.dismiss();
                            Toast.makeText(reactContext, "Cancel Opration", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .build();
            // Show Dialog
            mDialog.show();
        } catch (Exception e) {

        }
    }

    @ReactMethod
    public void gotoNativeScreen() {
        currentActivity = getCurrentActivity();
        currentActivity.startActivity(new Intent(reactContext, NativeActivity.class));
    }

}