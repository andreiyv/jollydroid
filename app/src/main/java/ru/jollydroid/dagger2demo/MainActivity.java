package ru.jollydroid.dagger2demo;

import android.app.NotificationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    private TextView hello;

    @Inject MyPreferences preferences;
    @Inject NotificationManager notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hello = (TextView)findViewById(R.id.hello);

// После вызова inject(this) в поле preferences будет объект класса MyPreferences.
        getAppComponent().inject(this);

        if (preferences.isVisited()) {
            hello.setText("welcome back");

        } else {
            hello.setText("Hello, anonymous");
            preferences.setVisited();
        }
    }

// Для того, чтобы получить доступ к компоненту из активити, мы должны дописать соответствующий метод.
// В дальнейшем этот метод можно будет перенести в общий для всех активити абстрактный суперкласс (в моих приложениях он как правило есть).
    AppComponent getAppComponent() {
        return ((MyApplication)getApplication()).getAppComponent();
    }
}
