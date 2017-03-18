package com.example.sumeet.sharedpreferencesassignment2;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Show extends AppCompatActivity {
    TextView tvName, tvAge, tvCity, tvPhno;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        tvName = (TextView) findViewById(R.id.name);
        tvAge = (TextView) findViewById(R.id.age);
        tvCity = (TextView) findViewById(R.id.city);
        tvPhno = (TextView) findViewById(R.id.phno);

        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("pref", 0); // 0 - for private mode


        String name, age, city, phno;

        name = sharedPreferences.getString("name", "null");
        age = sharedPreferences.getString("age", "null");
        city = sharedPreferences.getString("city", "null");
        phno = sharedPreferences.getString("phno", "null");

        tvName.setText(name);
        tvAge.setText(age);
        tvCity.setText(city);
        tvPhno.setText(phno);
    }
}
