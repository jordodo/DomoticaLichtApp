package com.example.jordi.domoticalichtapp;

import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.connection.channel.direct.Session;

import java.io.IOException;

/**
 * Created by Fkorz on 27-1-2017.
 */

public class networkConnect
{

    public static void buttonCommand(String command)
            throws IOException
    {
        final SSHClient ssh = new SSHClient();
        ssh.addHostKeyVerifier(new NullHostKeyVerifier());
        System.out.println("AAAAAAAAAAAAAAAAAAAHHHH");

        try
        {
            ssh.connect(Firsttimescreen.getIPAdress(), 22);
        }
        catch(Exception e)
        {
            System.out.println("dfgdfg");
            e.printStackTrace();
        }

        System.out.println("1");

        try
        {
            System.out.println("2");
            ssh.authPassword("pi", "wachtwoord");
            System.out.println("3");
            final Session session = ssh.startSession();
            System.out.println("4");
            try
            {
                System.out.println("Godverdomme dit fuking tering ding");
                final Session.Command cmd = session.exec(command);
                System.out.println("JAAAAAAAAAAAAAA");
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
