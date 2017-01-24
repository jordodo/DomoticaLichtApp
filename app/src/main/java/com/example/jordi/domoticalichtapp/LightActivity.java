package com.example.jordi.domoticalichtapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class LightActivity extends AppCompatActivity
{

    Switch lichtSwitch;
    TextView lichtText;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light);

        lichtSwitch = (Switch) findViewById(R.id.switch1);
        lichtText = (TextView) findViewById(R.id.textView);

        lichtSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if(isChecked)
                {
                    lichtText.setText("Licht staat aan");
                }
                else
                {
                    lichtText.setText("Licht staat uit");
                }


            }
        });


    }

}
