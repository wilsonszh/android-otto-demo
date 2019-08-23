package com.example.otto;

import android.app.Application;

public class OttoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //create Otto bus here (run once)
        OttoBus.createBus();
    }
}
