package ru.jollydroid.dagger2demo;

import android.app.Application;

public class MyApplication extends Application {
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent =
                DaggerAppComponent
                .builder()
                .androidModule(new AndroidModule(this))
                .appModule(new AppModule())
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}