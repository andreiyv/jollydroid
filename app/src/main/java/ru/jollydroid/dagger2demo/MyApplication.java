package ru.jollydroid.dagger2demo;

import android.app.Application;

// Не забываем указать класс MyApplication в AndroidManifest.xml в тэге <application>
public class MyApplication extends Application {
    private AppComponent appComponent;

    @Override
//  Чтобы не возиться с контекстом и не следить, когда первый раз будет запрошен экземпляр нашего хелпера,
//  превентивно инициализируем его в классе нашего приложения
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