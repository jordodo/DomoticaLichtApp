package com.example.jordi.domoticalichtapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.connection.channel.direct.Session;
import net.schmizz.sshj.connection.channel.direct.Session.Command;

import java.io.IOException;

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
                    try {
                        buttonCommand();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
                else
                {
                    lichtText.setText("Licht staat uit");
                    System.out.println("dfbdjfgbjdf");
                }


            }
        });


    }
    public void buttonCommand()
            throws IOException {
        final SSHClient ssh = new SSHClient();
        ssh.addHostKeyVerifier(new NullHostKeyVerifier());

        ssh.connect("192.168.1.5", 22);

        try {
            ssh.authPassword("pi", "raspberry");
            final Session session = ssh.startSession();
            try {
                final Command cmd = session.exec("ping www.google.com");
            } finally {
                session.close();
            }
        } finally {
            ssh.disconnect();
        }
    }
}
