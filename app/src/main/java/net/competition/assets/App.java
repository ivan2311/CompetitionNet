package net.competition.assets;

import android.app.Application;
import android.content.Context;

/**
 * Created by Korisnik on 7/24/2015.
 */
public class App extends Application {

    private static App instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static Context getContext() {
        return instance;
    }
}
