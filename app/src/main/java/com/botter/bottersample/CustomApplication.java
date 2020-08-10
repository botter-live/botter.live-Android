package com.botter.bottersample;

import android.app.Application;

import com.bluecrunch.chatwidget.integration.Botter;
import com.bluecrunch.chatwidget.integration.BotterCustomization;

/**
 * Created by karim on 10,August,2020
 */
public class CustomApplication extends Application {
    @Override public void onCreate() {
        super.onCreate();
        // Contact us to get your API key.
        Botter.initialize(this,"Your API key.",
                new BotterCustomization.Builder().build());
    }
}
