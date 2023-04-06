package com.solarph.switchingactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activityIntent = new Intent(this,AnotherActivity.class);
        spinner = (Spinner) findViewById(R.id.contentSpinner);
        initializeSpinner();
    }
    private Intent activityIntent;
    private Spinner spinner;
    public static String sharedKey_ITEM_A = "KEYITEM_A";
    private void initializeSpinner()
    {
        List<String> myItems = new ArrayList<String>();
        myItems.add("Item 1");
        myItems.add("Item 2");
        myItems.add("Item 3");
        myItems.add("OOGA BOOGA");
        myItems.add("Eyy naman");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item, myItems);

        spinner.setAdapter(adapter);
    }
    public void switchActivity(View view) {
        activityIntent.putExtra(sharedKey_ITEM_A, spinner.getSelectedItem().toString());
        startActivity(activityIntent);
    }
}
