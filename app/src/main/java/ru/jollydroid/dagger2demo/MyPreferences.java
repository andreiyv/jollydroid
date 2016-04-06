package ru.jollydroid.dagger2demo;

import android.content.Context;
import android.content.SharedPreferences;

public class MyPreferences {
    public static final String PREFS_NAME = "MyPrefsFile";
    private final SharedPreferences prefs;

    private MyPreferences(Context context) {
        prefs = context.getSharedPreferences(PREFS_NAME, 0);
    }

    static MyPreferences instance;
    public static MyPreferences getInstance() {
        return instance;
    }
    public synchronized static MyPreferences getInstance(Context context) {
        if (instance == null) {
            instance = new MyPreferences(context);
        }
        return instance;
    }

    private static final String visited = "visited";
    public boolean isVisited () {
        return prefs.getBoolean(visited, false);
    }
    public void setVisited() {
        prefs.edit().putBoolean(visited, true).apply();
    }
}