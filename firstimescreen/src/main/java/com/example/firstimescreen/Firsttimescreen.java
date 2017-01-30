package com.example.firstimescreen;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class Firsttimescreen extends AppCompatActivity{

    private Button btn1;
    private Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firsttimescreen);
        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                btn2.setEnabled(false);
                startActivity(new Intent(Firsttimescreen.this, Lightactivity.class));
                System.out.println("Button 2 staat uit");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn1.setEnabled(false);
                startActivity(new Intent(Firsttimescreen.this, Lightactivity.class));
                System.out.println("Button 1 staat uit");
            }
        });
    }}


