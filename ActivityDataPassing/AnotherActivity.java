package com.solarph.switchingactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class AnotherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);
        TextView tv = (TextView) findViewById(R.id.resultingView);
        tv.setText(getIntent().getStringExtra(MainActivity.sharedKey_ITEM_A));
    }
}
