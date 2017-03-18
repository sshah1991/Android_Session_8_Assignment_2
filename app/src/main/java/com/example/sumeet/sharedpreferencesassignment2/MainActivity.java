package com.example.sumeet.sharedpreferencesassignment2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name_et, age_et, city_et, phno_et;
    Button save_btn, show_btn;
    String text_name, text_age, text_phno, text_city;
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name_et = (EditText) findViewById(R.id.et_name);
        age_et = (EditText) findViewById(R.id.et_age);
        city_et = (EditText) findViewById(R.id.et_city);
        phno_et = (EditText) findViewById(R.id.et_phno);
        save_btn = (Button) findViewById(R.id.btn_save);
        show_btn = (Button) findViewById(R.id.btn_show);
        sharedpreferences = getSharedPreferences("pref", Context.MODE_PRIVATE);
        text_name = sharedpreferences.getString("name", "Null");
        text_age = sharedpreferences.getString("age", "Null");
        text_phno = sharedpreferences.getString("phno", "Null");
        text_city = sharedpreferences.getString("city", "Null");


        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString("name", text_name);
                editor.putString("age", text_age);
                editor.putString("phno", text_phno);
                editor.putString("city", text_city);
                editor.commit();
                Toast.makeText(MainActivity.this, "Preferences Saved.", Toast.LENGTH_LONG).show();


            }
        });

        show_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Show.class);
                startActivity(intent);

            }
        });

    }


}
