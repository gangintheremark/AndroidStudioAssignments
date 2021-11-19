package com.example.it;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = (Button) findViewById(R.id.button);
        Button btn2 = (Button) findViewById(R.id.button2);
        Button btn3 = (Button) findViewById(R.id.button3);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent (MainActivity.this, activity2.class);
                startActivity(myIntent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent (MainActivity.this, activity3.class);
                startActivity(myIntent);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent (MainActivity.this, activity5.class);
                startActivity(myIntent);
            }
        });
    }
}