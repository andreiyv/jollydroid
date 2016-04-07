package ru.jollydroid.dagger2demo;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    @Provides
    @Singleton
    MyPreferences providesMyPreferences(Context context) {
        return new MyPreferences(context);
    }
}