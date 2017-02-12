package org.polaric.colorful.sample;

import android.app.Application;

import org.polaric.colorful.Colorful;

public class SampleApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Colorful.defaults()
                .primaryColor(Colorful.ThemeColor.RED)
                .accentColor(Colorful.ThemeColor.BLUE)
                .translucent(true)
                .dark(false);

        Colorful.init(this);
    }
}
