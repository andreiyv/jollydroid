package ru.jollydroid.dagger2demo;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, AndroidModule.class})
public interface AppComponent {
    void inject(MainActivity activity);
}
