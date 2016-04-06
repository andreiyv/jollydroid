package ru.jollydroid.dagger2demo;

import android.app.Application;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        MyPreferences.getInstance(this);
    }
}