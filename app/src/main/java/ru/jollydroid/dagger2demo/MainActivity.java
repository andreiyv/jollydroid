package ru.jollydroid.dagger2demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView hello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hello = (TextView)findViewById(R.id.hello);
        if (MyPreferences.getInstance().isVisited()) {
            hello.setText("welcome back");
        } else {
            hello.setText("Hello, anonymous");
            MyPreferences.getInstance().setVisited();
        }
    }
}
