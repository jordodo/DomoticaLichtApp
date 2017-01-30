package com.example.jordi.domoticalichtapp;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class LightActivity extends AppCompatActivity
{

    Switch lichtSwitch;
    Switch lichtSwitch2;
    TextView lichtText;
    TextView lichtText2;

    public static final int MY_PERMISSIONS_REQUEST_INTERNET= 1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light);


        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.INTERNET)
                != PackageManager.PERMISSION_GRANTED)
        {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.INTERNET))
            {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            }
            else
            {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.INTERNET},
                        MY_PERMISSIONS_REQUEST_INTERNET);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        }



        lichtSwitch = (Switch) findViewById(R.id.switch1);
        lichtSwitch2 = (Switch) findViewById(R.id.switch2);
        lichtText = (TextView) findViewById(R.id.textView);
        lichtText2 = (TextView) findViewById(R.id.textView2);

        lichtSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if(isChecked)
                {
                    lichtText.setText("Licht staat aan");
                    try
                    {
                        new AsyncTask<Integer, Void, Void>()
                        {
                            @Override
                            protected Void doInBackground(Integer... params)
                            {
                                try
                                {
                                    networkConnect.buttonCommand("python /home/pi/Desktop/domoticascripts/lamp1aan.py");
                                    System.out.println("gelukt");
                                }
                                catch (Exception e)
                                {
                                    e.printStackTrace();
                                }
                                return null;
                            }
                        }.execute(1);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }

                }
                else
                {
                    lichtText.setText("Licht staat uit");
                    try
                    {
                        new AsyncTask<Integer, Void, Void>()
                        {
                            @Override
                            protected Void doInBackground(Integer... params)
                            {
                                try
                                {
                                    networkConnect.buttonCommand("python /home/pi/Desktop/domoticascripts/lamp1uit.py");
                                }
                                catch (Exception e)
                                {
                                    e.printStackTrace();
                                }
                                return null;
                            }
                        }.execute(1);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }


            }
        });

        lichtSwitch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if(isChecked)
                {
                    lichtText2.setText("Licht staat aan");
                    try
                    {
                        new AsyncTask<Integer, Void, Void>()
                        {
                            @Override
                            protected Void doInBackground(Integer... params)
                            {
                                try
                                {
                                    networkConnect.buttonCommand("python /home/pi/Desktop/domoticascripts/lamp2aan.py");
                                    System.out.println("gelukt");
                                }
                                catch (Exception e)
                                {
                                    e.printStackTrace();
                                }
                                return null;
                            }
                        }.execute(1);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }

                }
                else
                {
                    lichtText2.setText("Licht staat uit");
                    try
                    {
                        new AsyncTask<Integer, Void, Void>()
                        {
                            @Override
                            protected Void doInBackground(Integer... params)
                            {
                                try
                                {
                                    networkConnect.buttonCommand("python /home/pi/Desktop/domoticascripts/lamp2uit.py");
                                }
                                catch (Exception e)
                                {
                                    e.printStackTrace();
                                }
                                return null;
                            }
                        }.execute(1);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }


            }
        });


    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults)
    {
        switch (requestCode)
        {
            case MY_PERMISSIONS_REQUEST_INTERNET:
            {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.

                }
                else
                {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }
}
