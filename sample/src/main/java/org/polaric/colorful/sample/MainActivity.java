package org.polaric.colorful.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import org.polaric.colorful.ColorPickerDialog;
import org.polaric.colorful.Colorful;
import org.polaric.colorful.ColorfulActivity;

public class MainActivity extends ColorfulActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar(((Toolbar) findViewById(R.id.toolbar)));


    }

    public void choiceTheme(View view) {
        ColorPickerDialog dialog = new ColorPickerDialog(this);
        dialog.setOnColorSelectedListener(new ColorPickerDialog.OnColorSelectedListener() {
            @Override
            public void onColorSelected(Colorful.ThemeColor color) {
                //TODO: Do something with the color

                Colorful.config(MainActivity.this)
                        .primaryColor(color)
                        .accentColor(color)
                        .translucent(false)
                        .dark(false)
                        .apply();

                restart();


            }
        });
        dialog.show();
    }

    private void restart() {
        Intent intent = getIntent();
        overridePendingTransition(0, 0);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        finish();
        overridePendingTransition(0, 0);
        startActivity(intent);
    }
}
