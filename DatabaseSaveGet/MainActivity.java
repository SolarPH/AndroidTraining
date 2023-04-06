package com.solarph.databaseTest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataContent = (LinearLayout) findViewById(R.id.databaseContents);
        txt_Name = (EditText)findViewById(R.id.name1);
        txt_Pass = (EditText)findViewById(R.id.password1);
        dbms = new DatabaseManager(this);
    }

    DatabaseManager dbms;

    private LinearLayout dataContent;
    private EditText txt_Name, txt_Pass;

    private void saveDetails()
    {
        String contentA = txt_Name.getText().toString().trim();
        String contentB = txt_Pass.getText().toString().trim();
        if (contentA.equals("") || contentB.equals(""))
        {
            Toast.makeText(this,"Eyy, Wag!", Toast.LENGTH_LONG).show();
            return;
        }
        dbms.setData(contentA, contentB);
        txt_Name.setText("");
        txt_Pass.setText("");
        Toast.makeText(this,"Data Saved!", Toast.LENGTH_LONG).show();
    }

    private void getDetails()
    {
        String[][] contents = dbms.getData();
        dataContent.removeAllViews();
        for (int i=0; i<contents.length;i++)
        {
            LinearLayout container = new LinearLayout(this);
            container.setPadding(20,20,20,20);
            LinearLayout.LayoutParams lPar = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            lPar.setMargins(20,20,20,20);
            container.setLayoutParams(lPar);

            container.setBackgroundColor(Color.parseColor("#ff80ff"));
            container.setOrientation(LinearLayout.VERTICAL);
            TextView tvA = new TextView(this);
            tvA.setTextColor(Color.parseColor("#000000"));
            TextView tvB = new TextView(this);
            tvB.setTextColor(Color.parseColor("#000000"));
            tvA.setText(contents[i][0]);
            tvB.setText(contents[i][1]);
            container.addView(tvA);
            container.addView(tvB);
            dataContent.addView(container);
        }
    }

    public void doSave(View view) {
        saveDetails();
    }

    public void doGet(View view){
        getDetails();
    }
}
