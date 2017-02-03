package com.example.jordi.domoticalichtapp;

import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.connection.channel.direct.Session;

import java.io.IOException;

/**
 * Created by Fkorz on 27-1-2017.
 */

public class networkConnect
{
    // Functie maakt connectie met de opgegeven pi, en stuurt een request door.
    public static void buttonCommand(String command)
            throws IOException
    {
        final SSHClient ssh = new SSHClient();
        ssh.addHostKeyVerifier(new NullHostKeyVerifier());

        try
        {
            ssh.connect(Firsttimescreen.getIPAdress(), 22);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }


        try
        {
            ssh.authPassword("pi", "wachtwoord");
            final Session session = ssh.startSession();
            try
            {
                final Session.Command cmd = session.exec(command);
            }
            finally
            {
                session.close();
            }
        }
        finally
        {
            ssh.disconnect();
        }
    }
}
