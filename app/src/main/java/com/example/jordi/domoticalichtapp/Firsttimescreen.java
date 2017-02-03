package com.example.jordi.domoticalichtapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

//Eerste scherm om huis te kiezen
public class Firsttimescreen extends AppCompatActivity
{

    private Button btn1;
    private Button btn2;
    private static String ipAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firsttimescreen);
        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);
        btn1.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                btn2.setEnabled(false);
                ipAddress = "192.168.1.10";
                startActivity(new Intent(Firsttimescreen.this, LightActivity.class));
            }
        });
        btn2.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                btn1.setEnabled(false);
                ipAddress = "192.168.1.11";
                startActivity(new Intent(Firsttimescreen.this, LightActivity.class));
            }
        });
    }
    public static String getIPAdress()
    {
        return ipAddress;
    }
}


