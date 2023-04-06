package com.solarph.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    private int instanceLine = 1;
    public void addContent(View view)
    {
        TextView tv = new TextView(this);
        tv.setText("This is line " + instanceLine + "!");
        instanceLine++;
        LinearLayout ll = (LinearLayout) findViewById(R.id.contentContainer);
        ll.addView(tv);
        ((Button)findViewById(R.id.button)).setText("MLEM");
    }
}
