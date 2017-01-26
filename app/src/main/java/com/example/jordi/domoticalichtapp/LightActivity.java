package com.example.jordi.domoticalichtapp;

import android.content.pm.PackageInstaller;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.connection.channel.direct.Session;
import net.schmizz.sshj.connection.channel.direct.Session.Command;
import java.security.PublicKey;
import net.schmizz.sshj.transport.verification.HostKeyVerifier;

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
                }
                else
                {
                    lichtText.setText("Licht staat uit");
                }


            }
        });


    }
    public static void main(String... args)
            throws IOException {
        final SSHClient ssh = new SSHClient();
        ssh.addHostKeyVerifier(new NullHostKeyVerifier());

        ssh.connect("192.168.1.70", 22);

        try {
            ssh.authPassword("pi", "raspberry");
            final PackageInstaller.Session session = ssh.startSession();
            try {
                final Command cmd = session.exec("ls");
            } finally {
                session.close();
            }
        } finally {
            ssh.disconnect();
        }
    }
}
